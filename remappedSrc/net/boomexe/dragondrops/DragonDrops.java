package net.boomexe.dragondrops;

//import net.boomexe.dragondrops.block.DragonDropsBlocks;
import net.boomexe.dragondrops.config.ModConfigReader;
import net.boomexe.dragondrops.entity.ModEntities;
import net.boomexe.dragondrops.item.ModItemGroup;
import net.boomexe.dragondrops.item.ModItems;
import net.boomexe.dragondrops.util.ModLootTableModifiers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DragonDrops implements ModInitializer {
    public static final String MOD_ID = "dragondrops";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModConfigReader.initialize();

        ModItemGroup.registerItemGroups();
        ModItems.registerModItems();

//        DragonDropsBlocks.registerBlocks();
//        ModEntities.registerModEntities();
        ModLootTableModifiers.modifyLootTables();

        ModContainer container = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow();
        ResourceManagerHelper.registerBuiltinResourcePack(new Identifier(MOD_ID, "legacy-textures"), container, ResourcePackActivationType.NORMAL);

        LOGGER.info("Initialized Dragon Drops Mod");
    }
}
