package dev.thomasglasser.aliysium.rainbowoaks;


import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.client.RainbowOaksForgeClientEvents;
import dev.thomasglasser.aliysium.rainbowoaks.data.RainbowOaksDataGenerators;
import dev.thomasglasser.aliysium.rainbowoaks.platform.Services;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(RainbowOaks.MOD_ID)
public class RainbowOaksForge
{
    public RainbowOaksForge() {
        RainbowOaks.init();

        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(RainbowOaksDataGenerators::onGatherData);

        if (Services.PLATFORM.isClientSide())
        {
            bus.addListener(RainbowOaksForgeClientEvents::onRegisterBlockColors);
            bus.addListener(RainbowOaksForgeClientEvents::onRegisterItemColors);
            bus.addListener(RainbowOaksForgeClientEvents::onBuildCreativeModeTabContent);
        }
    }
}