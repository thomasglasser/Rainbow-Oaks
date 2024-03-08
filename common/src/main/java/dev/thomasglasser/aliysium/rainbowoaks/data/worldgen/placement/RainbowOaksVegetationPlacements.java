package dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.features.RainbowOaksVegetationFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

import static net.minecraft.data.worldgen.placement.VegetationPlacements.treePlacement;

public class RainbowOaksVegetationPlacements
{	public static final ResourceKey<PlacedFeature> FLOWER_FOREST_RAINBOW_OAK_TREES = create("flower_forest_rainbow_oak_trees");

	public static void bootstrap(BootstapContext<PlacedFeature> context)
	{
		HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);
		Holder<ConfiguredFeature<?, ?>> focusTrees = configuredFeatures.getOrThrow(RainbowOaksVegetationFeatures.FLOWER_FOREST_RAINBOW_OAK_TREES);
		PlacementUtils.register(context, FLOWER_FOREST_RAINBOW_OAK_TREES, focusTrees, treePlacement(RarityFilter.onAverageOnceEvery(3)));
	}

	public static ResourceKey<PlacedFeature> create(String name) {
		return ResourceKey.create(Registries.PLACED_FEATURE, RainbowOaks.modLoc(name));
	}
}
