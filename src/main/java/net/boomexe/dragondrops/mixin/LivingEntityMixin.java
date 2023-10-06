package net.boomexe.dragondrops.mixin;

import net.boomexe.dragondrops.item.ModItems;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityStatuses;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.damage.DamageTypes;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.stat.Stats;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity {
    @Shadow public abstract void setHealth(float health);

    @Shadow public abstract boolean clearStatusEffects();

    @Shadow public abstract boolean addStatusEffect(StatusEffectInstance effect);

    public LivingEntityMixin(EntityType<?> type, World world) {
        super(type, world);
    }

    @Inject(method = "tryUseTotem", at = @At("HEAD"), cancellable = true)
    void dragonTotem(DamageSource damageSource, CallbackInfoReturnable<Boolean> cir) {
        Entity entity = this;
        LivingEntity livingEntity = (LivingEntity) entity;

        ItemStack stackInMainHand = livingEntity.getMainHandStack();
        ItemStack stackInOffHand = livingEntity.getOffHandStack();

        boolean mainHandIsTotem = stackInMainHand.isOf(ModItems.DRAGON_TOTEM);
        boolean offHandIsTotem = stackInOffHand.isOf(ModItems.DRAGON_TOTEM);

        if (mainHandIsTotem || offHandIsTotem)
        {
            if (mainHandIsTotem) {
                stackInMainHand.decrement(1);
            } else {
                stackInOffHand.decrement(1);
            }

            this.setHealth(5);
            this.clearStatusEffects();

            if (damageSource.isOf(DamageTypes.OUT_OF_WORLD))
            {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 2));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 4));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 100, 99));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOW_FALLING, 1000, 0));

            }
            else {
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 900, 2));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 200, 2));
                this.addStatusEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 800, 0));
            }

            this.getWorld().sendEntityStatus(this, EntityStatuses.USE_TOTEM_OF_UNDYING);

            try {
                ServerPlayerEntity serverPlayerEntity = (ServerPlayerEntity) entity;
                serverPlayerEntity.incrementStat(Stats.USED.getOrCreateStat(ModItems.DRAGON_TOTEM));
                Criteria.USED_TOTEM.trigger(serverPlayerEntity, mainHandIsTotem? stackInMainHand : stackInOffHand);
            } catch (Exception ignored) {}

            cir.setReturnValue(true);
        }
    }
}
