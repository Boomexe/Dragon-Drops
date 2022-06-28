package net.boomexe.dragondrops.item;

import net.boomexe.dragondrops.DragonDrops;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static final ItemGroup DRAGON_DROPS = FabricItemGroupBuilder.build(new Identifier(DragonDrops.MOD_ID, "dragon_drops"),
            () -> new ItemStack(ModItems.DRAGON_SCALE));
}
