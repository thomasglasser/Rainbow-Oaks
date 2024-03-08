package dev.thomasglasser.aliysium.rainbowoaks.world.level.block;

import com.mojang.datafixers.util.Pair;
import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.registration.RegistrationProvider;
import dev.thomasglasser.aliysium.rainbowoaks.registration.RegistryObject;
import dev.thomasglasser.aliysium.rainbowoaks.world.item.RainbowOaksItems;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.grower.RainbowTreeGrower;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.grower.OakTreeGrower;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import org.apache.commons.lang3.function.TriFunction;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class RainbowOaksBlocks
{
	public static final Function<RegistryObject<? extends Block>, BlockItem> BLOCK_ITEM_FUNCTION = ((block) -> new BlockItem(block.get(), new Item.Properties()));

	public static final RegistrationProvider<Block> BLOCKS = RegistrationProvider.get(Registries.BLOCK, RainbowOaks.MOD_ID);

	public static final RegistryObject<RotatedPillarBlock> RAINBOW_LOG = registerBlockAndItemAndWrap("rainbow_log", () -> Blocks.log(MapColor.WOOD, MapColor.PODZOL), List.of(CreativeModeTabs.BUILDING_BLOCKS, CreativeModeTabs.NATURAL_BLOCKS));
	public static final RegistryObject<LeavesBlock> RAINBOW_LEAVES = registerBlockAndItemAndWrap("rainbow_leaves", () -> Blocks.leaves(SoundType.GRASS), List.of(CreativeModeTabs.NATURAL_BLOCKS));
	public static final Pair<RegistryObject<SaplingBlock>, RegistryObject<FlowerPotBlock>> RAINBOW_SAPLING = registerSaplingAndPottedAndItemAndWrap("rainbow", () -> new SaplingBlock(new RainbowTreeGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), List.of(CreativeModeTabs.NATURAL_BLOCKS));

	public static <T extends Block> RegistryObject<T> registerBlockAndItemAndWrap(
			String name,
			Supplier<T> blockFactory,
			List<ResourceKey<CreativeModeTab>> tabs)
	{
		RegistryObject<T> block = BLOCKS.register(name, blockFactory);
		RainbowOaksItems.register(name, () -> BLOCK_ITEM_FUNCTION.apply(block), tabs);
		return block;
	}

	protected static Pair<RegistryObject<SaplingBlock>, RegistryObject<FlowerPotBlock>> registerSaplingAndPottedAndItemAndWrap(
			String name,
			Supplier<SaplingBlock> blockFactory,
			List<ResourceKey<CreativeModeTab>> tabs)
	{
		RegistryObject<SaplingBlock> sapling = registerBlockAndItemAndWrap(name + "_sapling", blockFactory, tabs);
		return Pair.of(sapling, BLOCKS.register("potted_" + name + "_sapling", () -> Blocks.flowerPot(sapling.get())));
	}

	public static void init() {}
}
