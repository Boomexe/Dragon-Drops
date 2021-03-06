package net.boomexe.dragondrops.entity;

import net.boomexe.dragondrops.entity.custom.DragonTridentEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModEntities {
    public static final EntityType<DragonTridentEntity> DRAGON_TRIDENT_ENTITY = FabricEntityTypeBuilder.<DragonTridentEntity>create(SpawnGroup.MISC, DragonTridentEntity::new).dimensions(EntityDimensions.fixed(0.5F, 0.5F)).build();

    public static void registerModEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier("dragondrops", "dragon_trident"), DRAGON_TRIDENT_ENTITY);
    }
}
