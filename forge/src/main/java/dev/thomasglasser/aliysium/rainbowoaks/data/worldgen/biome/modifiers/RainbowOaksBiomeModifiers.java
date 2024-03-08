package dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.biome.modifiers;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement.RainbowOaksVegetationPlacements;
import dev.thomasglasser.aliysium.rainbowoaks.tags.RainbowOaksBiomeTags;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

public class RainbowOaksBiomeModifiers
{
	private static ResourceKey<BiomeModifier> register(String name)
	{
		return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, RainbowOaks.modLoc(name));
	}

	public static void bootstrap(BootstapContext<BiomeModifier> context)
	{
		HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
		HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);

		// Add features
		Holder.Reference<PlacedFeature> rainbowOakTrees = placedFeatures.getOrThrow(RainbowOaksVegetationPlacements.FLOWER_FOREST_RAINBOW_OAK_TREES);
		context.register(register("add_rainbow_oak_trees"), new ForgeBiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(RainbowOaksBiomeTags.HAS_RAINBOW_OAK_TREES), HolderSet.direct(rainbowOakTrees), GenerationStep.Decoration.VEGETAL_DECORATION));
	}
}
