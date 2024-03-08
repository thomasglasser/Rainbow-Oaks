package dev.thomasglasser.aliysium.rainbowoaks.data.loot;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;

import java.util.List;
import java.util.Set;

public class RainbowOaksLootTables extends LootTableProvider
{
	public RainbowOaksLootTables(PackOutput packOutput) {
		super(packOutput, Set.of(), List.of(
				new SubProviderEntry(RainbowOaksBlockLoot::new, LootContextParamSets.BLOCK)));
	}
}
