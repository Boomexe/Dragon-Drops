package net.boomexe.dragondrops.util;

import net.boomexe.dragondrops.DragonDrops;
import net.boomexe.dragondrops.item.ModItems;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

import java.util.concurrent.ThreadLocalRandom;

public class ModLootTableModifiers {
    private static final Identifier DRAGON_ID
            = new Identifier("minecraft", "entities/ender_dragon");

    public static void modifyLootTables() {
        LootTableEvents.MODIFY.register(((resourceManager, lootManager, id, tableBuilder, source) -> {
            if (source.isBuiltin() && DRAGON_ID.equals(id)) {
                LootPool.Builder poolBuilder = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.DRAGON_FRAGMENT))
                        .rolls(ConstantLootNumberProvider.create(ThreadLocalRandom.current().nextInt(DragonDrops.config.dragon_shards_scales.minimum_fragments, DragonDrops.config.dragon_shards_scales.maximum_fragments) + 1));

                tableBuilder.pool(poolBuilder);
            }
        }));
    }
}