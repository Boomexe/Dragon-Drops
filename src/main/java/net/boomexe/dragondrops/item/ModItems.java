package net.boomexe.dragondrops.item;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
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
            new DragonTotemItem(new FabricItemSettings().maxCount(1)));

    public static final Item DRAGON_BOW = registerItem("dragon_bow",
            new DragonBowItem(new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS).maxDamage(520)));

    public static Item DRAGON_HELMET = registerItem("dragon_helmet",
            new ArmorItem(ModArmorMaterials.DRAGON, EquipmentSlot.HEAD,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static Item DRAGON_CHESTPLATE = registerItem("dragon_chestplate",
            new ArmorItem(ModArmorMaterials.DRAGON, EquipmentSlot.CHEST,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static Item DRAGON_LEGGINGS = registerItem("dragon_leggings",
            new ArmorItem(ModArmorMaterials.DRAGON, EquipmentSlot.LEGS,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

    public static Item DRAGON_BOOTS = registerItem("dragon_boots",
            new ArmorItem(ModArmorMaterials.DRAGON, EquipmentSlot.FEET,
                    new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS)));

//    public static final Item DRAGON_TRIDENT = registerItem("dragon_trident",
//            new DragonTridentItem(new FabricItemSettings().group(ModItemGroup.DRAGON_DROPS).maxDamage(420)));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(DragonDrops.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DragonDrops.LOGGER.info("Registering Mod Items for " + DragonDrops.MOD_ID);
    }
}
