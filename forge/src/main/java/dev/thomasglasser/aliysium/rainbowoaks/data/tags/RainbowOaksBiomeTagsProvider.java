package dev.thomasglasser.aliysium.rainbowoaks.data.tags;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.tags.RainbowOaksBiomeTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.BiomeTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class RainbowOaksBiomeTagsProvider extends BiomeTagsProvider
{
	public RainbowOaksBiomeTagsProvider(PackOutput p_255800_, CompletableFuture<HolderLookup.Provider> p_256205_, @Nullable ExistingFileHelper existingFileHelper)
	{
		super(p_255800_, p_256205_, RainbowOaks.MOD_ID, existingFileHelper);
	}

	@Override
	protected void addTags(HolderLookup.Provider pProvider)
	{
		tag(RainbowOaksBiomeTags.HAS_RAINBOW_OAK_TREES)
				.add(Biomes.FLOWER_FOREST);
	}
}
