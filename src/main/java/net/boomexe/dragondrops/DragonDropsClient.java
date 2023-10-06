package net.boomexe.dragondrops;

import net.boomexe.dragondrops.client.render.entity.feature.DragonElytraFeatureRenderer;
import net.boomexe.dragondrops.util.ModModelPredicateProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.LivingEntityFeatureRendererRegistrationCallback;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.model.ArmorStandEntityModel;
import net.minecraft.client.render.entity.model.BipedEntityModel;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

public class DragonDropsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
//        EntityRendererRegistry.register(ModEntities.DRAGON_TRIDENT_ENTITY, DragonTridentEntityRenderer::new);

        LivingEntityFeatureRendererRegistrationCallback.EVENT.register(((EntityType<? extends LivingEntity> entityType, LivingEntityRenderer<?, ?> entityRenderer, LivingEntityFeatureRendererRegistrationCallback.RegistrationHelper registrationHelper, EntityRendererFactory.Context context) -> {
            if (entityRenderer.getModel() instanceof PlayerEntityModel || entityRenderer.getModel() instanceof BipedEntityModel || entityRenderer.getModel() instanceof ArmorStandEntityModel) {
                registrationHelper.register(new DragonElytraFeatureRenderer<>(entityRenderer, context.getModelLoader()));
            }
        }));

        ModModelPredicateProvider.registerModModels();
    }
}
