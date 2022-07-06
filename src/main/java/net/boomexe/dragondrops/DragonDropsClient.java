package net.boomexe.dragondrops;

import net.boomexe.dragondrops.entity.ModEntities;
import net.boomexe.dragondrops.entity.custom.DragonTridentEntityRenderer;
import net.boomexe.dragondrops.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class DragonDropsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.DRAGON_TRIDENT_ENTITY, DragonTridentEntityRenderer::new);

        ModModelPredicateProvider.registerModModels();
    }
}
