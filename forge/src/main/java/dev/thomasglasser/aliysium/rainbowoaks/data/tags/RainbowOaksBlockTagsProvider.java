package dev.thomasglasser.aliysium.rainbowoaks.data.tags;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RainbowOaksBlockTagsProvider extends BlockTagsProvider
{
	public RainbowOaksBlockTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(output, lookupProvider, RainbowOaks.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider)
	{
		tag(BlockTags.LEAVES)
				.add(RainbowOaksBlocks.RAINBOW_LEAVES.get());
		tag(BlockTags.LOGS_THAT_BURN)
				.add(RainbowOaksBlocks.RAINBOW_LOG.get());
	}
}
