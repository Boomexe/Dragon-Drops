package net.boomexe.dragondrops.entity.custom;

import net.boomexe.dragondrops.DragonDrops;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.model.TridentEntityModel;
import net.minecraft.util.Identifier;

public class DragonTridentEntityRenderer1 extends EntityRenderer<DragonTridentEntity> {
    public static final Identifier TEXTURE = new Identifier(DragonDrops.MOD_ID,"textures/entity/dragon_trident.png");
    private final TridentEntityModel model = new TridentEntityModel(TridentEntityModel.getTexturedModelData().createModel());;

    public DragonTridentEntityRenderer1(EntityRendererFactory.Context context) {
        super(context);
//        this.model = new TridentEntityModel(context.getPart(EntityModelLayers.TRIDENT));
    }

//    public void render(DragonTridentEntity tridentEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
//        matrixStack.push();
//        matrixStack.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(MathHelper.lerp(g, tridentEntity.prevYaw, tridentEntity.getYaw()) - 90.0F));
//        matrixStack.multiply(RotationAxis.POSITIVE_Z.rotationDegrees(MathHelper.lerp(g, tridentEntity.prevPitch, tridentEntity.getPitch()) + 90.0F));
//        VertexConsumer vertexConsumer = ItemRenderer.getDirectItemGlintConsumer(vertexConsumerProvider, this.model.getLayer(this.getTexture(tridentEntity)), false, tridentEntity.isEnchanted());
//        this.model.render(matrixStack, vertexConsumer, i, OverlayTexture.DEFAULT_UV, 1.0F, 1.0F, 1.0F, 1.0F);
//        matrixStack.pop();
//        super.render(tridentEntity, f, g, matrixStack, vertexConsumerProvider, i);
//    }

    @Override
    public Identifier getTexture(DragonTridentEntity tridentEntity) { return TEXTURE; }
}
