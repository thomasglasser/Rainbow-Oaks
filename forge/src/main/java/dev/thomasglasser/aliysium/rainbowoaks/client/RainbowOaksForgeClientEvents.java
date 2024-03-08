package dev.thomasglasser.aliysium.rainbowoaks.client;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.world.item.RainbowOaksItems;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RainbowOaksForgeClientEvents
{
	public static void onRegisterBlockColors(RegisterColorHandlersEvent.Block event)
	{
		event.register(new RainbowOaksClientEvents.RainbowLeavesBlockColor(), RainbowOaksBlocks.RAINBOW_LEAVES.get());
	}

	public static void onRegisterItemColors(RegisterColorHandlersEvent.Item event)
	{
		event.register(new RainbowOaksClientEvents.RainbowLeavesItemColor(), RainbowOaksBlocks.RAINBOW_LEAVES.get().asItem());
	}

	public static void onBuildCreativeModeTabContent(BuildCreativeModeTabContentsEvent event)
	{
		event.acceptAll(RainbowOaksItems.getItemsForTab(event.getTabKey()));
	}
}
