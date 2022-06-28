package net.boomexe.dragondrops;

import net.boomexe.dragondrops.item.ModItems;
import net.boomexe.dragondrops.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragonDrops implements ModInitializer {
    public static final String MOD_ID = "dragondrops";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItems.registerModItems();
        ModLootTableModifiers.modifyLootTables();

        LOGGER.info("Initialized Dragon Drops Mod");
    }
}
