package net.boomexe.dragondrops.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DragonPickaxeItem extends PickaxeItem {
    public DragonPickaxeItem(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.dragondrops.dragon_pickaxe.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.dragondrops.dragon_pickaxe.tooltip"));
        }
    }

    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EntityType targetType = target.getType();
        Float extraDamage = 6f;

        if (targetType == EntityType.ENDERMAN || targetType == EntityType.ENDER_DRAGON || targetType == EntityType.ENDERMITE || targetType == EntityType.SHULKER) {
            target.damage(DamageSource.player((PlayerEntity) attacker), extraDamage);
        }
        return super.postHit(stack, target, attacker);
    }
}
