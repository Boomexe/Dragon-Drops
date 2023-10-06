package net.boomexe.dragondrops.item.custom;

import net.boomexe.dragondrops.DragonDrops;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;

import java.util.List;

public class ModSmithingTemplateItem extends SmithingTemplateItem {
    public ModSmithingTemplateItem(Text appliesToText, Text ingredientsText, Text titleText, Text baseSlotDescriptionText, Text additionsSlotDescriptionText, List<Identifier> emptyBaseSlotTextures, List<Identifier> emptyAdditionsSlotTextures) {
        super(appliesToText, ingredientsText, titleText, baseSlotDescriptionText, additionsSlotDescriptionText, emptyBaseSlotTextures, emptyAdditionsSlotTextures);
    }

    private static final Formatting TITLE_FORMATTING = Formatting.GRAY;
    private static final Formatting DESCRIPTION_FORMATTING = Formatting.BLUE;

    private static final Identifier EMPTY_ARMOR_SLOT_HELMET_TEXTURE = new Identifier("item/empty_armor_slot_helmet");
    private static final Identifier EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE = new Identifier("item/empty_armor_slot_chestplate");
    private static final Identifier EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE = new Identifier("item/empty_armor_slot_leggings");
    private static final Identifier EMPTY_ARMOR_SLOT_BOOTS_TEXTURE = new Identifier("item/empty_armor_slot_boots");
    private static final Identifier EMPTY_SLOT_HOE_TEXTURE = new Identifier("item/empty_slot_hoe");
    private static final Identifier EMPTY_SLOT_AXE_TEXTURE = new Identifier("item/empty_slot_axe");
    private static final Identifier EMPTY_SLOT_SWORD_TEXTURE = new Identifier("item/empty_slot_sword");
    private static final Identifier EMPTY_SLOT_SHOVEL_TEXTURE = new Identifier("item/empty_slot_shovel");
    private static final Identifier EMPTY_SLOT_PICKAXE_TEXTURE = new Identifier("item/empty_slot_pickaxe");
    private static final Identifier EMPTY_SLOT_BOW_TEXTURE = new Identifier(DragonDrops.MOD_ID, "item/empty_slot_bow");
    private static final Identifier EMPTY_SLOT_SCALE_TEXTURE = new Identifier(DragonDrops.MOD_ID, "item/empty_slot_dragon_scale");

    private static final Text DRAGON_UPGRADE_TEXT = Text.translatable(Util.createTranslationKey("upgrade", new Identifier(DragonDrops.MOD_ID, "dragon_upgrade"))).formatted(TITLE_FORMATTING);

    private static final Text DRAGON_UPGRADE_APPLIES_TO_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(DragonDrops.MOD_ID, "smithing_template.dragon_upgrade.applies_to"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text DRAGON_UPGRADE_INGREDIENTS_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(DragonDrops.MOD_ID, "smithing_template.dragon_upgrade.ingredients"))).formatted(DESCRIPTION_FORMATTING);
    private static final Text DRAGON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(DragonDrops.MOD_ID, "smithing_template.dragon_upgrade.base_slot_description")));
    private static final Text DRAGON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT = Text.translatable(Util.createTranslationKey("item", new Identifier(DragonDrops.MOD_ID, "smithing_template.dragon_upgrade.additions_slot_description")));


    public static ModSmithingTemplateItem createDragonUpgrade() {
        return new ModSmithingTemplateItem(DRAGON_UPGRADE_APPLIES_TO_TEXT, DRAGON_UPGRADE_INGREDIENTS_TEXT, DRAGON_UPGRADE_TEXT, DRAGON_UPGRADE_BASE_SLOT_DESCRIPTION_TEXT, DRAGON_UPGRADE_ADDITIONS_SLOT_DESCRIPTION_TEXT, ModSmithingTemplateItem.getDragonUpgradeEmptyBaseSlotTextures(), ModSmithingTemplateItem.getDragonUpgradeEmptyAdditionsSlotTextures());
    }

    private static List<Identifier> getDragonUpgradeEmptyBaseSlotTextures() {
        return List.of(EMPTY_ARMOR_SLOT_HELMET_TEXTURE, EMPTY_SLOT_SWORD_TEXTURE, EMPTY_ARMOR_SLOT_CHESTPLATE_TEXTURE, EMPTY_SLOT_PICKAXE_TEXTURE, EMPTY_ARMOR_SLOT_LEGGINGS_TEXTURE, EMPTY_SLOT_AXE_TEXTURE, EMPTY_ARMOR_SLOT_BOOTS_TEXTURE, EMPTY_SLOT_HOE_TEXTURE, EMPTY_SLOT_SHOVEL_TEXTURE, EMPTY_SLOT_BOW_TEXTURE);
    }

    private static List<Identifier> getDragonUpgradeEmptyAdditionsSlotTextures() {
        return List.of(EMPTY_SLOT_SCALE_TEXTURE);
    }
}
