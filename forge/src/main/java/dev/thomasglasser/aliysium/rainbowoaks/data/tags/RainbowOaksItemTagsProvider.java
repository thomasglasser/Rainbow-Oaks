package dev.thomasglasser.aliysium.rainbowoaks.data.tags;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.concurrent.CompletableFuture;

public class RainbowOaksItemTagsProvider extends ItemTagsProvider
{
	public static final TagKey<Item> RAINBOW_LOGS = ItemTags.create(RainbowOaks.modLoc("rainbow_logs"));

	public RainbowOaksItemTagsProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> future, CompletableFuture<TagsProvider.TagLookup<Block>> blockTagsProvider, ExistingFileHelper existingFileHelper) {
		super(output, future, blockTagsProvider, RainbowOaks.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider)
	{
		tag(RAINBOW_LOGS)
				.add(RainbowOaksBlocks.RAINBOW_LOG.get().asItem());
	}
}
