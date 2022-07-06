package net.boomexe.dragondrops.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;

public class DragonDropsConfigReader {
    public static DragonDropsConfig config = new DragonDropsConfig();

    public static void initialize() {
        AutoConfig.register(DragonDropsConfig.class, JanksonConfigSerializer::new).getConfig();
        config = AutoConfig.getConfigHolder(DragonDropsConfig.class).getConfig();
    }
}
