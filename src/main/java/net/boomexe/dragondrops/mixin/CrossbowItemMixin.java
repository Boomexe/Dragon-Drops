package net.boomexe.dragondrops.mixin;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.ModItems;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {
    @Inject(method ="createArrow", at = @At("RETURN"))
    private static void modifyPierceLevel (World world, LivingEntity entity, ItemStack crossbow, ItemStack arrow, CallbackInfoReturnable<PersistentProjectileEntity> cir) {
        PersistentProjectileEntity arrowEntity = cir.getReturnValue();

        if (crossbow.isOf(ModItems.DRAGON_CROSSBOW)) {
            arrowEntity.setPierceLevel((byte) (EnchantmentHelper.getLevel(Enchantments.PIERCING, crossbow) + DragonDrops.config.dragon_crossbow.base_piercing_level));
        }
    }
}
