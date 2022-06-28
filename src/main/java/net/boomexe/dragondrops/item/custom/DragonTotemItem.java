package net.boomexe.dragondrops.item.custom;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class DragonTotemItem extends Item {
    public DragonTotemItem(Settings settings) {
        super(settings);
    }

    Double tpX = 0d;
    Double tpY = 0d;
    Double tpZ = 0d;

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (Screen.hasShiftDown()) {
            tooltip.add(Text.translatable("item.dragondrops.dragon_totem.tooltip.shift"));
        } else {
            tooltip.add(Text.translatable("item.dragondrops.dragon_totem.tooltip"));
        }
    }

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, world, entity, slot, selected);

        if (selected && entity.isOnGround()) {
            tpX = entity.getX();
            tpY = entity.getY();
            tpZ = entity.getZ();
        }

        if (selected && entity.getX() <= -100) {
            entity.setPosition(tpX, tpY, tpZ);
        }
    }
}
