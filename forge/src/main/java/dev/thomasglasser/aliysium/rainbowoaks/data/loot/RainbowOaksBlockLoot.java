package dev.thomasglasser.aliysium.rainbowoaks.data.loot;

import dev.thomasglasser.aliysium.rainbowoaks.registration.RegistryObject;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class RainbowOaksBlockLoot extends BlockLootSubProvider
{
	protected RainbowOaksBlockLoot()
	{
		super(Set.of(), FeatureFlags.REGISTRY.allFlags());
	}

	@Override
	protected void generate()
	{
		dropSelf(RainbowOaksBlocks.RAINBOW_LOG.get());
		add(RainbowOaksBlocks.RAINBOW_LEAVES.get(), createLeavesDrops(RainbowOaksBlocks.RAINBOW_LEAVES.get(), RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().get(), NORMAL_LEAVES_SAPLING_CHANCES));
		dropSelf(RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().get());
		dropPottedContents(RainbowOaksBlocks.RAINBOW_SAPLING.getSecond().get());
	}

	@Override
	protected Iterable<Block> getKnownBlocks()
	{
		return RainbowOaksBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get).toList();
	}
}
