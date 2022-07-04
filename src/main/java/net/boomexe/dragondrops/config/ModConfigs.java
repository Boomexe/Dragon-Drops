package net.boomexe.dragondrops.config;

import com.mojang.datafixers.util.Pair;
import net.boomexe.dragondrops.DragonDrops;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;

    public static Float DRAGON_ARMOR_TOUGHNESS;
    public static Float DRAGON_ARMOR_KNOCKBACK;

    public static void registerServerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(DragonDrops.MOD_ID + "serverconfig").provider(configs).request();

        assignConfigs();
    }

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("dragon.armor.toughness", 3), "float");
        configs.addKeyValuePair(new Pair<>("dragon.armor.knockback", 0.05), "float");
    }

    private static void assignConfigs() {
        DRAGON_ARMOR_TOUGHNESS = CONFIG.getOrDefault("dragon.armor.toughness", 3F);
        DRAGON_ARMOR_KNOCKBACK = CONFIG.getOrDefault("dragon.armor.knockback", 0.05F);

        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }
}