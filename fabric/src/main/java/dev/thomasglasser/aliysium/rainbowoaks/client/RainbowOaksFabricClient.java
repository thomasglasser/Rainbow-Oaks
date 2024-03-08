package dev.thomasglasser.aliysium.rainbowoaks.client;

import dev.thomasglasser.aliysium.rainbowoaks.world.item.RainbowOaksItems;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.registries.BuiltInRegistries;

public class RainbowOaksFabricClient implements ClientModInitializer
{
	@Override
	public void onInitializeClient()
	{
		ColorProviderRegistry.BLOCK.register(new RainbowOaksClientEvents.RainbowLeavesBlockColor(), RainbowOaksBlocks.RAINBOW_LEAVES.get());
		ColorProviderRegistry.ITEM.register(new RainbowOaksClientEvents.RainbowLeavesItemColor(), RainbowOaksBlocks.RAINBOW_LEAVES.get());

		ItemGroupEvents.MODIFY_ENTRIES_ALL.register((group, entries) ->
				entries.acceptAll(RainbowOaksItems.getItemsForTab(BuiltInRegistries.CREATIVE_MODE_TAB.getResourceKey(group).orElseThrow())));
	}
}
