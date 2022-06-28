package net.boomexe.dragondrops.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DragonSwordItem extends SwordItem {
    public DragonSwordItem(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.dragondrops.dragon_sword.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.dragondrops.dragon_sword.tooltip"));
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EntityType targetType = target.getType();
        Float extraDamage = 6f;

        if (targetType == EntityType.ENDERMAN || targetType == EntityType.ENDER_DRAGON || targetType == EntityType.ENDERMITE || targetType == EntityType.SHULKER) {
            target.damage(DamageSource.player((PlayerEntity) attacker), extraDamage);
            attacker.getWorld().playSound(null, attacker.getX(), attacker.getY(), attacker.getZ(), SoundEvents.ENTITY_PLAYER_ATTACK_CRIT, SoundCategory.PLAYERS, 0.7f, 1f);
        }
        return super.postHit(stack, target, attacker);
    }
}
