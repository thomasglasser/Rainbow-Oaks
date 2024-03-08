package dev.thomasglasser.aliysium.rainbowoaks;

import dev.thomasglasser.aliysium.rainbowoaks.platform.Services;
import dev.thomasglasser.aliysium.rainbowoaks.world.item.RainbowOaksItems;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.resources.ResourceLocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RainbowOaks
{
    public static final String MOD_ID = "rainbowoaks";
    public static final String MOD_NAME = "Rainbow Oaks";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static void init() {
        LOGGER.info("Initializing {} for {} in a {} environment...", MOD_NAME, Services.PLATFORM.getPlatformName(), Services.PLATFORM.getEnvironmentName());

        RainbowOaksItems.init();
        RainbowOaksBlocks.init();
    }

    public static ResourceLocation modLoc(String s)
    {
        return new ResourceLocation(MOD_ID, s);
    }
}