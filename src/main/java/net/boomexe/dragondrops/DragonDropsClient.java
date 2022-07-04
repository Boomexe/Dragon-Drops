package net.boomexe.dragondrops;

import net.boomexe.dragondrops.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;

public class DragonDropsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        ModModelPredicateProvider.registerModModels();
    }
}
