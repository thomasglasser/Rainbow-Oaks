package dev.thomasglasser.aliysium.rainbowoaks.platform;


import dev.thomasglasser.aliysium.rainbowoaks.platform.services.PlatformHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.loading.FMLLoader;

public class ForgePlatformHelper implements PlatformHelper
{

    @Override
    public String getPlatformName() {

        return "NeoForge";
    }

    @Override
    public boolean isModLoaded(String modId) {

        return ModList.get().isLoaded(modId);
    }

    @Override
    public boolean isDevelopmentEnvironment() {

        return !FMLLoader.isProduction();
    }

    @Override
    public boolean isClientSide()
    {
        return FMLLoader.getDist() == Dist.CLIENT;
    }
}