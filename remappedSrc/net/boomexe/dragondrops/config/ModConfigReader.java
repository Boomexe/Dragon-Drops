package net.boomexe.dragondrops.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class ModConfigReader {
    public static ModConfig config = new ModConfig();

    public static void initialize() {
        AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new).getConfig();
        config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
    }
}
