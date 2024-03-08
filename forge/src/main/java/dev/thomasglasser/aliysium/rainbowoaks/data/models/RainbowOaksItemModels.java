package dev.thomasglasser.aliysium.rainbowoaks.data.models;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RainbowOaksItemModels extends ItemModelProvider
{
	public RainbowOaksItemModels(PackOutput output, ExistingFileHelper existingFileHelper)
	{
		super(output, RainbowOaks.MOD_ID, existingFileHelper);
	}

	@Override
	protected void registerModels()
	{
		withExistingParent(RainbowOaksBlocks.RAINBOW_LOG.getId().getPath(), modLoc("block/" + RainbowOaksBlocks.RAINBOW_LOG.getId().getPath()));
		withExistingParent(RainbowOaksBlocks.RAINBOW_LEAVES.getId().getPath(), modLoc("block/" + RainbowOaksBlocks.RAINBOW_LEAVES.getId().getPath()));
		withExistingParent(RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().getId().getPath(), modLoc("block/" + RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().getId().getPath()));
	}
}
