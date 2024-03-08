package dev.thomasglasser.aliysium.rainbowoaks.data.blockstates;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaksForge;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class RainbowOaksBlockStates extends BlockStateProvider
{
	public RainbowOaksBlockStates(PackOutput output, ExistingFileHelper exFileHelper)
	{
		super(output, RainbowOaks.MOD_ID, exFileHelper);
	}

	@Override
	protected void registerStatesAndModels()
	{
		simpleBlock(RainbowOaksBlocks.RAINBOW_LEAVES.get(), models().withExistingParent(RainbowOaksBlocks.RAINBOW_LEAVES.getId().getPath(), mcLoc("block/" + BuiltInRegistries.BLOCK.getKey(Blocks.OAK_LEAVES).getPath())));
		logBlock(RainbowOaksBlocks.RAINBOW_LOG.get());
		simpleBlock(RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().get(), models().cross(RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().getId().getPath(), modLoc("block/" + RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().getId().getPath())).renderType("cutout"));
		simpleBlock(RainbowOaksBlocks.RAINBOW_SAPLING.getSecond().get(), models().withExistingParent(RainbowOaksBlocks.RAINBOW_SAPLING.getSecond().getId().getPath(), mcLoc("block/flower_pot_cross")).texture("plant", modLoc("block/" + RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().getId().getPath())).renderType("cutout"));
	}
}
