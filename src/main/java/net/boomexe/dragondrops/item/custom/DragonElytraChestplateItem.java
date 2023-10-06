package net.boomexe.dragondrops.item.custom;

import net.boomexe.dragondrops.item.ModItems;
import net.fabricmc.fabric.api.entity.event.v1.FabricElytraItem;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;

public class DragonElytraChestplateItem extends ArmorItem implements FabricElytraItem {
    public DragonElytraChestplateItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public boolean canRepair(ItemStack stack, ItemStack ingredient) {
        return ingredient.isOf(ModItems.DRAGON_SCALE);
    }
}
