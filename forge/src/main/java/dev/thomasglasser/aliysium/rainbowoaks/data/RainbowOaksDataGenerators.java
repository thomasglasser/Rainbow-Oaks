package dev.thomasglasser.aliysium.rainbowoaks.data;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.data.blockstates.RainbowOaksBlockStates;
import dev.thomasglasser.aliysium.rainbowoaks.data.lang.RainbowOaksEnUsLanguageProvider;
import dev.thomasglasser.aliysium.rainbowoaks.data.loot.RainbowOaksLootTables;
import dev.thomasglasser.aliysium.rainbowoaks.data.models.RainbowOaksItemModels;
import dev.thomasglasser.aliysium.rainbowoaks.data.recipes.RainbowOaksRecipes;
import dev.thomasglasser.aliysium.rainbowoaks.data.tags.RainbowOaksBiomeTagsProvider;
import dev.thomasglasser.aliysium.rainbowoaks.data.tags.RainbowOaksBlockTagsProvider;
import dev.thomasglasser.aliysium.rainbowoaks.data.tags.RainbowOaksItemTagsProvider;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.biome.modifiers.RainbowOaksBiomeModifiers;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.features.RainbowOaksTreeFeatures;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.features.RainbowOaksVegetationFeatures;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement.RainbowOaksTreePlacements;
import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement.RainbowOaksVegetationPlacements;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.features.TreeFeatures;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class RainbowOaksDataGenerators
{
	private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
			.add(ForgeRegistries.Keys.BIOME_MODIFIERS, RainbowOaksBiomeModifiers::bootstrap)
			.add(Registries.CONFIGURED_FEATURE, (pContext ->
			{
				RainbowOaksTreeFeatures.bootstrap(pContext);
				RainbowOaksVegetationFeatures.bootstrap(pContext);
			}))
			.add(Registries.PLACED_FEATURE, (pContext ->
			{
				RainbowOaksTreePlacements.bootstrap(pContext);
				RainbowOaksVegetationPlacements.bootstrap(pContext);
			}));

	public static void onGatherData(GatherDataEvent event)
	{
		DataGenerator generator = event.getGenerator();
		PackOutput output = generator.getPackOutput();
		ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
		CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

		boolean onServer = event.includeServer();
		boolean onClient = event.includeClient();

		// Client
		generator.addProvider(onClient, new RainbowOaksBlockStates(output, existingFileHelper));
		generator.addProvider(onClient, new RainbowOaksEnUsLanguageProvider(output));
		generator.addProvider(onClient, new RainbowOaksItemModels(output, existingFileHelper));

		// Server
		BlockTagsProvider blockTagsProvider = new RainbowOaksBlockTagsProvider(output, lookupProvider, existingFileHelper);
		generator.addProvider(onServer, blockTagsProvider);
		generator.addProvider(onServer, new RainbowOaksLootTables(output));
		generator.addProvider(onServer, new DatapackBuiltinEntriesProvider(output, lookupProvider, BUILDER, Set.of(RainbowOaks.MOD_ID)));
		generator.addProvider(onServer, new RainbowOaksItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper));
		generator.addProvider(onServer, new RainbowOaksRecipes(output));
		generator.addProvider(onServer, new RainbowOaksBiomeTagsProvider(output, lookupProvider, existingFileHelper));
	}
}
