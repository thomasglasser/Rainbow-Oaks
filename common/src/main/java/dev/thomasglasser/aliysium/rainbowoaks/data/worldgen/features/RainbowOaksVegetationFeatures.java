package dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.features;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement.RainbowOaksTreePlacements;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.List;

public class RainbowOaksVegetationFeatures
{
	public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_FOREST_RAINBOW_OAK_TREES = create("flower_forest_rainbow_oak_trees");

	public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context)
	{
		HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
		Holder.Reference<PlacedFeature> rainbowOakFancyBees0002 = placedFeatures.getOrThrow(RainbowOaksTreePlacements.FANCY_RAINBOW_OAK_BEES_0002);
		FeatureUtils.register(context, FLOWER_FOREST_RAINBOW_OAK_TREES, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(rainbowOakFancyBees0002, 0.2f)), rainbowOakFancyBees0002));
	}

	public static ResourceKey<ConfiguredFeature<?, ?>> create(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, RainbowOaks.modLoc(name));
	}
}
