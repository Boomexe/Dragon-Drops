package net.boomexe.dragondrops.item;

import net.boomexe.dragondrops.DragonDrops;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroup {
    public static ItemGroup DRAGON_DROPS = Registry.register(Registries.ITEM_GROUP, new Identifier(DragonDrops.MOD_ID, "dragon_drops"),
            FabricItemGroup.builder()
                    .displayName(Text.translatable("itemgroup.dragon_drops"))
                    .icon(() -> new ItemStack(ModItems.DRAGON_SCALE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.DRAGON_FRAGMENT);
                        entries.add(ModItems.DRAGON_SCALE);
                        entries.add(ModItems.DRAGON_UPGRADE_SMITHING_TEMPLATE);
                        entries.add(ModItems.DRAGON_SWORD);
                        entries.add(ModItems.DRAGON_AXE);
                        entries.add(ModItems.DRAGON_PICKAXE);
                        entries.add(ModItems.DRAGON_SHOVEL);
                        entries.add(ModItems.DRAGON_HOE);
                        entries.add(ModItems.DRAGON_BOW);
                        entries.add(ModItems.DRAGON_CROSSBOW);
                        entries.add(ModItems.DRAGON_HELMET);
                        entries.add(ModItems.DRAGON_CHESTPLATE);
                        entries.add(ModItems.DRAGON_LEGGINGS);
                        entries.add(ModItems.DRAGON_BOOTS);
//                        entries.add(ModItems.DRAGON_TRIDENT);
                        entries.add(ModItems.DRAGON_ELYTRA);
                        entries.add(ModItems.DRAGON_ELYTRA_CHESTPLATE);
                        entries.add(ModItems.DRAGON_TOTEM);


                    }).build());

    public static void registerItemGroups() {
        DragonDrops.LOGGER.info("Registering Mod Item Groups for " + DragonDrops.MOD_ID);
    }
}
