package net.boomexe.dragondrops.event;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.ModToolMaterials;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ToolItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class AttackEntityHandler implements AttackEntityCallback {
    @Override
    public ActionResult interact(PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) {
        Item item = player.getMainHandStack().getItem();

        if (item instanceof ToolItem toolItem) {
            if (toolItem.getMaterial() == ModToolMaterials.DRAGON) {
                if ((entity.getType() == EntityType.ENDERMAN || entity.getType() == EntityType.ENDER_DRAGON || entity.getType() == EntityType.ENDERMITE || entity.getType() == EntityType.SHULKER) && !world.isClient() && !player.isSpectator()) {
                    int sharpnessLevel = EnchantmentHelper.getLevel(Enchantments.SHARPNESS, player.getMainHandStack());
                    float attackCooldown = player.getAttackCooldownProgress(0.5F);

                    float enchantmentDamage = 1.0F + (sharpnessLevel - 1) * 0.5F;

                    float potentialDamage = (float) (player.getAttributeValue(EntityAttributes.GENERIC_ATTACK_DAMAGE) + enchantmentDamage + DragonDrops.config.dragon_tools.bonus_attack_damage);

                    float trueDamage = potentialDamage * (0.2F + attackCooldown * attackCooldown * 0.8F);

                    entity.damage(world.getDamageSources().playerAttack(player), trueDamage);
                }
            }
        }

        return ActionResult.PASS;
    }
}
