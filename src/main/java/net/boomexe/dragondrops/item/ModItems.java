package net.boomexe.dragondrops.item;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.custom.*;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DRAGON_FRAGMENT = registerItem("dragon_fragment",
        new Item(new FabricItemSettings()));

    public static final Item DRAGON_SCALE = registerItem("dragon_scale",
            new Item(new FabricItemSettings().maxCount(DragonDrops.config.dragon_shards_scales.scale_stack_size)));

    public static final Item DRAGON_SWORD = registerItem("dragon_sword",
            new DragonSwordItem(ModToolMaterials.DRAGON, 3, -2.4f,
                    new FabricItemSettings()));

    public static final Item DRAGON_AXE = registerItem("dragon_axe",
            new DragonAxeItem(ModToolMaterials.DRAGON, 5, -3f,
                    new FabricItemSettings()));

    public static final Item DRAGON_PICKAXE = registerItem("dragon_pickaxe",
            new DragonPickaxeItem(ModToolMaterials.DRAGON, 1, -2.8f,
                    new FabricItemSettings()));

    public static final Item DRAGON_SHOVEL = registerItem("dragon_shovel",
            new DragonShovelItem(ModToolMaterials.DRAGON, 1.5f, -3f,
                    new FabricItemSettings()));

    public static final Item DRAGON_HOE = registerItem("dragon_hoe",
            new DragonHoeItem(ModToolMaterials.DRAGON, -3, 0,
                    new FabricItemSettings()));

    public static final Item DRAGON_TOTEM = registerItem("dragon_totem",
            new DragonTotemItem(new FabricItemSettings().maxCount(1)));

    public static final Item DRAGON_BOW = registerItem("dragon_bow",
            new DragonBowItem(new FabricItemSettings().maxDamage(DragonDrops.config.dragon_bow.durability)));

    public static final Item DRAGON_CROSSBOW = registerItem("dragon_crossbow",
            new CrossbowItem(new FabricItemSettings().maxDamage(DragonDrops.config.dragon_crossbow.durability)));

    public static final Item DRAGON_HELMET = registerItem("dragon_helmet",
            new ArmorItem(ModArmorMaterials.DRAGON, ArmorItem.Type.HELMET,
                    new FabricItemSettings()));

    public static final Item DRAGON_CHESTPLATE = registerItem("dragon_chestplate",
            new ArmorItem(ModArmorMaterials.DRAGON, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));

    public static final Item DRAGON_LEGGINGS = registerItem("dragon_leggings",
            new ArmorItem(ModArmorMaterials.DRAGON, ArmorItem.Type.LEGGINGS,
                    new FabricItemSettings()));

    public static final Item DRAGON_BOOTS = registerItem("dragon_boots",
            new ArmorItem(ModArmorMaterials.DRAGON, ArmorItem.Type.BOOTS,
                    new FabricItemSettings()));

    public static final Item DRAGON_ELYTRA = registerItem("dragon_elytra",
            new DragonElytraItem(new FabricItemSettings().maxDamage(500)));

    public static final Item DRAGON_ELYTRA_CHESTPLATE = registerItem("dragon_elytra_chestplate",
            new DragonElytraChestplateItem(ModArmorMaterials.DRAGON, ArmorItem.Type.CHESTPLATE,
                    new FabricItemSettings()));

//    public static final Item DRAGON_TRIDENT = registerItem("dragon_trident",
//            new DragonTridentItem(new FabricItemSettings().maxDamage(420)));

    public static final Item DRAGON_UPGRADE_SMITHING_TEMPLATE = registerItem("dragon_upgrade_smithing_template",
            ModSmithingTemplateItem.createDragonUpgrade());

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(DragonDrops.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DragonDrops.LOGGER.info("Registering Mod Items for " + DragonDrops.MOD_ID);
    }
}
