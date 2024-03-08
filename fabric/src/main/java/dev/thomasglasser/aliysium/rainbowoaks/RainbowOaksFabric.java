package dev.thomasglasser.aliysium.rainbowoaks;

import dev.thomasglasser.aliysium.rainbowoaks.data.worldgen.placement.RainbowOaksVegetationPlacements;
import dev.thomasglasser.aliysium.rainbowoaks.tags.RainbowOaksBiomeTags;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.minecraft.world.level.levelgen.GenerationStep;

public class RainbowOaksFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        RainbowOaks.init();

        BiomeModifications.addFeature(biomeSelectionContext -> biomeSelectionContext.hasTag(RainbowOaksBiomeTags.HAS_RAINBOW_OAK_TREES), GenerationStep.Decoration.VEGETAL_DECORATION, RainbowOaksVegetationPlacements.FLOWER_FOCUS_RAINBOW_OAK_TREES);
    }
}