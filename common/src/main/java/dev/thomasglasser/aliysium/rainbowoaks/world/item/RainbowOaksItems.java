package dev.thomasglasser.aliysium.rainbowoaks.world.item;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.registration.RegistrationProvider;
import dev.thomasglasser.aliysium.rainbowoaks.registration.RegistryObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

public class RainbowOaksItems
{
	public static final RegistrationProvider<Item> ITEMS = RegistrationProvider.get(Registries.ITEM, RainbowOaks.MOD_ID);
	private static final HashMap<ResourceKey<CreativeModeTab>, ArrayList<ResourceLocation>> ITEM_TABS = new HashMap<>();

	public static Map<ResourceKey<CreativeModeTab>, ArrayList<ResourceLocation>> getItemTabs() {
		return ITEM_TABS;
	}

	public static <T extends Item> RegistryObject<T> register(String name, Supplier<T> item, List<ResourceKey<CreativeModeTab>> tabs)
	{
		for (ResourceKey<CreativeModeTab> tab: tabs) {
			ArrayList<ResourceLocation> list = getItemTabs().computeIfAbsent(tab, empty -> new ArrayList<>());
			list.add(RainbowOaks.modLoc(name));
		}
		return ITEMS.register(name, item);
	}

	public static List<ItemStack> getItemsForTab(ResourceKey<CreativeModeTab> tab)
	{
		List<ItemStack> items = new ArrayList<>();

		RainbowOaksItems.getItemTabs().forEach((itemTab, itemLikes) -> {
			if (tab == itemTab)
			{
				itemLikes.forEach((itemLike) -> items.add(Objects.requireNonNull(BuiltInRegistries.ITEM.get(itemLike)).getDefaultInstance()));
			}
		});

		return items;
	}

	public static void init() {}
}
