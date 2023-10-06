/*
 * MIT License
 *
 * Copyright (c) 2021-2023 OroArmor (Eli Orona)
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */


package net.boomexe.dragondrops.client.render.entity.feature;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.PlayerModelPart;
import net.minecraft.client.render.entity.feature.FeatureRenderer;
import net.minecraft.client.render.entity.feature.FeatureRendererContext;
import net.minecraft.client.render.entity.model.ElytraEntityModel;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.render.entity.model.EntityModelLoader;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DragonElytraFeatureRenderer<T extends LivingEntity, M extends EntityModel<T>> extends FeatureRenderer<T, M> {
    public static final Identifier DRAGON_ELYTRA_SKIN = new Identifier(DragonDrops.MOD_ID, "textures/entity/dragon_elytra.png");
    private final ElytraEntityModel<T> elytra;

    public DragonElytraFeatureRenderer(FeatureRendererContext<T, M> featureRendererContext, EntityModelLoader entityModelLoader) {
        super(featureRendererContext);
        this.elytra = new ElytraEntityModel<>(entityModelLoader.getModelPart(EntityModelLayers.ELYTRA));
    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, T livingEntity, float f, float g, float h, float j, float k, float l) {
        ItemStack itemStack = livingEntity.getEquippedStack(EquipmentSlot.CHEST);
        if (itemStack.isOf(ModItems.DRAGON_ELYTRA) || itemStack.isOf(ModItems.DRAGON_ELYTRA_CHESTPLATE)) {
            Identifier identifier4;
            if (livingEntity instanceof AbstractClientPlayerEntity abstractClientPlayerEntity) {
                if (abstractClientPlayerEntity.canRenderElytraTexture() && abstractClientPlayerEntity.getElytraTexture() != null) {
                    identifier4 = abstractClientPlayerEntity.getElytraTexture();
                } else if (abstractClientPlayerEntity.canRenderCapeTexture() && abstractClientPlayerEntity.getCapeTexture() != null && abstractClientPlayerEntity.isPartVisible(PlayerModelPart.CAPE)) {
                    identifier4 = abstractClientPlayerEntity.getCapeTexture();
                } else {
                    identifier4 = DRAGON_ELYTRA_SKIN;
                }
            } else {
                identifier4 = DRAGON_ELYTRA_SKIN;
            }

            matrixStack.push();
            matrixStack.translate(0.0D, 0.0D, 0.125D);
            getContextModel().copyStateTo(this.elytra);
            this.elytra.setAngles(livingEntity, f, g, j, k, l);
            VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.elytra.getLayer(identifier4), false, itemStack.hasGlint());
            this.elytra.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
            matrixStack.pop();
        }
    }

}