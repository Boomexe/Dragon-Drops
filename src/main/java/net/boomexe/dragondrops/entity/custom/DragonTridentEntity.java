package net.boomexe.dragondrops.entity.custom;

import net.boomexe.dragondrops.mixin.old_trident_stuff.TridentEntityAccessor;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class DragonTridentEntity extends TridentEntity {
    public DragonTridentEntity(EntityType<? extends TridentEntity> entityType, World world) {
        super(entityType, world);
    }

    public DragonTridentEntity(World world, LivingEntity owner, ItemStack stack) {
        super(world, owner, stack);

        ((TridentEntityAccessor) this).setTridentStack(stack.copy());
    }
}
