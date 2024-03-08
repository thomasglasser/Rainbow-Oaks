package dev.thomasglasser.aliysium.rainbowoaks.tags;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class RainbowOaksBiomeTags
{
	public static final TagKey<Biome> HAS_RAINBOW_OAK_TREES = create(RainbowOaks.modLoc("has_rainbow_oak_trees"));

	private static TagKey<Biome> create(ResourceLocation pName) {
		return TagKey.create(Registries.BIOME, pName);
	}
}
