package dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.features.RainbowOaksTreeFeatures;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.Supplier;

public class RainbowOaksTreePlacements
{
	public static final ResourceKey<PlacedFeature> RAINBOW_OAK_CHECKED = create("rainbow_oak_checked");
	public static final ResourceKey<PlacedFeature> FANCY_RAINBOW_OAK_CHECKED = create("fancy_rainbow_oak_checked");
	public static final ResourceKey<PlacedFeature> RAINBOW_OAK_BEES_0002 = create("rainbow_oak_bees_0002");
	public static final ResourceKey<PlacedFeature> RAINBOW_OAK_BEES_002 = create("rainbow_oak_bees_002");
	public static final ResourceKey<PlacedFeature> FANCY_RAINBOW_OAK_BEES_0002 = create("fancy_rainbow_oak_bees_0002");
	public static final ResourceKey<PlacedFeature> FANCY_RAINBOW_OAK_BEES_002 = create("fancy_rainbow_oak_bees_002");
	public static final ResourceKey<PlacedFeature> FANCY_RAINBOW_OAK_BEES = create("fancy_rainbow_oak_bees");

	public static void bootstrap(BootstapContext<PlacedFeature> pContext) {
		HolderGetter<ConfiguredFeature<?, ?>> features = pContext.lookup(Registries.CONFIGURED_FEATURE);
		registerTreeSet(pContext, features, RainbowOaksBlocks.RAINBOW_SAPLING.getFirst()::get,
				RainbowOaksTreeFeatures.RAINBOW_OAK, RainbowOaksTreeFeatures.FANCY_RAINBOW_OAK, RainbowOaksTreeFeatures.RAINBOW_OAK_BEES_0002, RainbowOaksTreeFeatures.RAINBOW_OAK_BEES_002, RainbowOaksTreeFeatures.FANCY_RAINBOW_OAK_BEES_0002, RainbowOaksTreeFeatures.FANCY_RAINBOW_OAK_BEES_002, RainbowOaksTreeFeatures.FANCY_RAINBOW_OAK_BEES,
				RAINBOW_OAK_CHECKED, FANCY_RAINBOW_OAK_CHECKED, RAINBOW_OAK_BEES_0002, RAINBOW_OAK_BEES_002, FANCY_RAINBOW_OAK_BEES_0002, FANCY_RAINBOW_OAK_BEES_002, FANCY_RAINBOW_OAK_BEES);
	}

	public static void registerTreeSet(BootstapContext<PlacedFeature> pContext, HolderGetter<ConfiguredFeature<?, ?>> features, Supplier<Block> sapling, ResourceKey<ConfiguredFeature<?, ?>> normalConfigured, ResourceKey<ConfiguredFeature<?, ?>> fancyConfigured, ResourceKey<ConfiguredFeature<?, ?>> normalBees0002Configured, ResourceKey<ConfiguredFeature<?, ?>> normalBees002Configured, ResourceKey<ConfiguredFeature<?, ?>> fancyBees0002Configured, ResourceKey<ConfiguredFeature<?, ?>> fancyBees002Configured, ResourceKey<ConfiguredFeature<?, ?>> fancyBeesConfigured, ResourceKey<PlacedFeature> normal, ResourceKey<PlacedFeature> fancy, ResourceKey<PlacedFeature> normalBees0002, ResourceKey<PlacedFeature> normalBees002, ResourceKey<PlacedFeature> fancyBees0002, ResourceKey<PlacedFeature> fancyBees002, ResourceKey<PlacedFeature> fancyBees)
	{
		Holder<ConfiguredFeature<?, ?>> holder2 = features.getOrThrow(normalConfigured);
		Holder<ConfiguredFeature<?, ?>> holder11 = features.getOrThrow(fancyConfigured);
		Holder<ConfiguredFeature<?, ?>> holder19 = features.getOrThrow(normalBees0002Configured);
		Holder<ConfiguredFeature<?, ?>> holder20 = features.getOrThrow(normalBees002Configured);
		Holder<ConfiguredFeature<?, ?>> holder23 = features.getOrThrow(fancyBees0002Configured);
		Holder<ConfiguredFeature<?, ?>> holder24 = features.getOrThrow(fancyBees002Configured);
		Holder<ConfiguredFeature<?, ?>> holder25 = features.getOrThrow(fancyBeesConfigured);
		PlacementUtils.register(pContext, normal, holder2, PlacementUtils.filteredByBlockSurvival(sapling.get()));
		PlacementUtils.register(pContext, fancy, holder11, PlacementUtils.filteredByBlockSurvival(sapling.get()));
		PlacementUtils.register(pContext, normalBees0002, holder19, PlacementUtils.filteredByBlockSurvival(sapling.get()));
		PlacementUtils.register(pContext, normalBees002, holder20, PlacementUtils.filteredByBlockSurvival(sapling.get()));
		PlacementUtils.register(pContext, fancyBees0002, holder23, PlacementUtils.filteredByBlockSurvival(sapling.get()));
		PlacementUtils.register(pContext, fancyBees002, holder24, PlacementUtils.filteredByBlockSurvival(sapling.get()));
		PlacementUtils.register(pContext, fancyBees, holder25, PlacementUtils.filteredByBlockSurvival(sapling.get()));
	}

	private static ResourceKey<PlacedFeature> create(String pKey) {
		return ResourceKey.create(Registries.PLACED_FEATURE, RainbowOaks.modLoc(pKey));
	}
}
