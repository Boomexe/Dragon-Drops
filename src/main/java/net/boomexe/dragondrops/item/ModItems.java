package net.boomexe.dragondrops.item;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    public static final Item DRAGON_FRAGMENT = registerItem("dragon_fragment",
        new Item(new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static final Item DRAGON_SCALE = registerItem("dragon_scale",
            new Item(new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS).maxCount(16)));

    public static final Item DRAGON_SWORD = registerItem("dragon_sword",
            new DragonSwordItem(ModToolMaterials.DRAGON, 3, -2.4f,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static final Item DRAGON_AXE = registerItem("dragon_axe",
            new DragonAxeItem(ModToolMaterials.DRAGON, 5, -3f,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static final Item DRAGON_PICKAXE = registerItem("dragon_pickaxe",
            new DragonPickaxeItem(ModToolMaterials.DRAGON, 1, -2.8f,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static final Item DRAGON_SHOVEL = registerItem("dragon_shovel",
            new DragonShovelItem(ModToolMaterials.DRAGON, 1.5f, -3f,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static final Item DRAGON_HOE = registerItem("dragon_hoe",
            new DragonHoeItem(ModToolMaterials.DRAGON, -3, 0,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static final Item DRAGON_TOTEM = registerItem("dragon_totem",
            new DragonTotemItem(new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS).maxCount(1)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DragonDrops.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DragonDrops.LOGGER.info("Registering Mod Items for " + DragonDrops.MOD_ID);
    }
}
