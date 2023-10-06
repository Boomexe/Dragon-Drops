package net.boomexe.dragondrops.mixin.old_trident_stuff;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.entity.custom.DragonTridentEntity;
import net.minecraft.client.render.entity.TridentEntityRenderer;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TridentEntityRenderer.class)
public class TridentEntityRendererMixin {
        @Inject(method = "getTexture(Lnet/minecraft/entity/projectile/TridentEntity;)Lnet/minecraft/util/Identifier;", at = @At(value = "HEAD"), cancellable = true)
        public void getTextureMixin(TridentEntity entity, CallbackInfoReturnable<Identifier> cir) {
            ItemStack tridentStack = ((TridentEntityAccessor) entity).getTridentStack();
            DragonTridentEntity dragonTridentEntity = null;

            try {
                dragonTridentEntity = (DragonTridentEntity) entity;
            } catch (Exception ignore) {}
            if (dragonTridentEntity != null) {
                cir.setReturnValue(new Identifier(DragonDrops.MOD_ID, "textures/entity/dragon_trident.png"));
                System.out.println("Trident Entity: " + tridentStack.getName());
            }
        }
}
