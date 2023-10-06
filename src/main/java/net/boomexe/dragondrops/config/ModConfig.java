package net.boomexe.dragondrops.config;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

@Config(name = "dragondrops")
@Config.Gui.Background("minecraft:textures/block/end_stone.png")
public class ModConfig implements ConfigData {
    @ConfigEntry.Gui.CollapsibleObject
    public DragonShardsScales dragon_shards_scales = new DragonShardsScales();
    @ConfigEntry.Gui.CollapsibleObject
    public DragonTools dragon_tools = new DragonTools();

    @ConfigEntry.Gui.CollapsibleObject
    public DragonArmor dragon_armor = new DragonArmor();

    @ConfigEntry.Gui.CollapsibleObject
    public DragonBow dragon_bow = new DragonBow();

    @ConfigEntry.Gui.CollapsibleObject
    public DragonCrossBow dragon_crossbow = new DragonCrossBow();

    public static class DragonShardsScales {
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Minimum amount of Dragon Fragments the Ender Dragon will drop on death.\nThis must be less than maximum fragments!")
        @ConfigEntry.BoundedDiscrete(max=128, min=0)
        public int minimum_fragments = 9;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Maximum amount of Dragon Fragments the Ender Dragon will drop on death.\nThis must be greater than minimum fragments!")
        @ConfigEntry.BoundedDiscrete(max=128, min=1)
        public int maximum_fragments = 27;
        @ConfigEntry.Gui.RequiresRestart
        @ConfigEntry.BoundedDiscrete(max=64, min=1)
        @Comment("Stack size for Dragon Scales")
        public int scale_stack_size = 16;
    }

    public static class DragonTools {
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Attack damage for all weapons.\nNote: A bit finicky, you probably shouldn't change this without knowing what you're doing!")
        public float attack_damage = 5;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("How lucky the enchantment rolls will be on both tools and armor.\nNetherite is 15, and Diamond is 10.")
        public int enchantability = 20;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Mining Speed of Dragon Tools.\nNetherite is 9, Gold is 12.")
        public float mining_speed = 10;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Durability of Dragon Tools.\nNetherite is 2031.")
        public int durability = 2620;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Sets bonus attack damage for end mobs.\nDefault is 8")
        public float bonus_attack_damage = 8;
    }

    public static class DragonArmor {
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite Helmet is 3")
        public int helmet_protection = 4;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite Chestplate is 8")
        public int chestplate_protection = 9;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite Leggings is 6")
        public int leggings_protection = 7;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite Boots is 3")
        public int boots_protection = 4;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite is 37")
        public int durability_multiplier = 42;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite is 3, Diamond is 2")
        public float toughness = 3;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Netherite is 0.1")
        public float knockback_resistance = 0.05F;
    }

    public static class DragonBow {
        @Comment("How fast the arrow shoots.\nNormal bow is 3")
        public float speed = 4F;
        @Comment("How accurate the bow is (0 < == less accurate)\nNormal bow is 1")
        public float divergence = 0.7F;
        @ConfigEntry.Gui.RequiresRestart
        @Comment("Normal bow has 385 durability")
        public int durability = 520;
    }

    public static class DragonCrossBow {
        @Comment("Normal crossbow has 465")
        public int durability = 610;
        @Comment("Base piercing level. Normal crossbow has 0")
        public int base_piercing_level = 2;
    }
}
