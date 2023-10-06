package net.boomexe.dragondrops.mixin;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.entity.custom.DragonTridentEntity;
import net.boomexe.dragondrops.item.ModItems;
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
//        System.out.println("Trident Entity: " + tridentStack.getName());
        if (tridentStack.isOf(ModItems.DRAGON_TRIDENT)) {
            cir.setReturnValue(new Identifier(DragonDrops.MOD_ID, "textures/entity/dragon_trident.png"));
        }
    }
}
