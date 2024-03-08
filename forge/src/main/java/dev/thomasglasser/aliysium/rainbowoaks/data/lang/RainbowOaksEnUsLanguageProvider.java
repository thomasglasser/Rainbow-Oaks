package dev.thomasglasser.aliysium.rainbowoaks.data.lang;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.world.level.block.RainbowOaksBlocks;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class RainbowOaksEnUsLanguageProvider extends LanguageProvider
{
	public RainbowOaksEnUsLanguageProvider(PackOutput output)
	{
		super(output, RainbowOaks.MOD_ID, "en_us");
	}

	@Override
	protected void addTranslations()
	{
		add(RainbowOaksBlocks.RAINBOW_LEAVES.get(), "Rainbow Leaves");
		add(RainbowOaksBlocks.RAINBOW_LOG.get(), "Rainbow Log");
		add(RainbowOaksBlocks.RAINBOW_SAPLING.getFirst().get(), "Rainbow Sapling");
		add(RainbowOaksBlocks.RAINBOW_SAPLING.getSecond().get(), "Potted Rainbow Sapling");
	}
}
