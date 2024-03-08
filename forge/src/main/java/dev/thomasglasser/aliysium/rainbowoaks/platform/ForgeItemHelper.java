package dev.thomasglasser.aliysium.rainbowoaks.platform;

import dev.thomasglasser.aliysium.rainbowoaks.platform.services.ItemHelper;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.ForgeSpawnEggItem;

import java.util.function.Supplier;

public class ForgeItemHelper implements ItemHelper
{
	@Override
	public Attribute getAttackRangeAttribute() {
		return ForgeMod.ENTITY_REACH.get();
	}

	@Override
	public Supplier<SpawnEggItem> makeSpawnEgg(Supplier<EntityType<? extends Mob>> entityType, int bg, int fg, Item.Properties properties) {
		return () -> new ForgeSpawnEggItem(entityType, bg, fg, properties);
	}

	@SafeVarargs
	@Override
	public final CreativeModeTab newTab(Component title, Supplier<ItemStack> icon, boolean search, CreativeModeTab.DisplayItemsGenerator displayItems, ResourceKey<CreativeModeTab>... tabsBefore) {
		CreativeModeTab.Builder builder = CreativeModeTab.builder().title(title).icon(icon).displayItems(displayItems).withTabsBefore(tabsBefore);
		if (search) builder.withSearchBar();
		return builder.build();
	}
}
