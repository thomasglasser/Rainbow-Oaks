package dev.thomasglasser.aliysium.rainbowoaks.world.level.block.grower;

import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.features.RainbowOaksTreeFeatures;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class RainbowTreeGrower extends AbstractTreeGrower
{
	public RainbowTreeGrower() {
	}

	protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
		if (random.nextInt(10) == 0) {
			return hasFlowers ? RainbowOaksTreeFeatures.FANCY_RAINBOW_OAK_BEES_005 : RainbowOaksTreeFeatures.FANCY_RAINBOW_OAK;
		} else {
			return hasFlowers ? RainbowOaksTreeFeatures.RAINBOW_OAK_BEES_005 : RainbowOaksTreeFeatures.RAINBOW_OAK;
		}
	}
}
