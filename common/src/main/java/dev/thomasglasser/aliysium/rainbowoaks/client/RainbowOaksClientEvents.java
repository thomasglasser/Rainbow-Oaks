package dev.thomasglasser.aliysium.rainbowoaks.client;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class RainbowOaksClientEvents
{
	public static class RainbowLeavesItemColor implements ItemColor
	{
		@Override
		public int getColor(@NotNull ItemStack stack, int tintIndex)
		{
			int red = 0;
			int green = 0;
			int blue = 0;

			for (int i = -1; i <= 1; ++i)
			{
				for (int j = -1; j <= 1; ++j)
				{
					int averageColor = FoliageColor.getDefaultColor();
					red += (averageColor & 16711680) >> 16;
					green += (averageColor & 65280) >> 8;
					blue += averageColor & 255;
				}
			}

			red = stack.getCount() * 64;
			if ((red & 256) != 0)
			{
				red = 255 - (red & 255);
			}
			red &= 255;

			blue = stack.getCount() * 32;
			if ((blue & 256) != 0)
			{
				blue = 255 - (blue & 255);
			}
			blue ^= 255;

			green = stack.getCount();
			if ((green & 256) != 0)
			{
				green = 255 - (green & 255);
			}
			green &= 255;

			return red << 16 | blue << 8 | green;
		}
	}

	public static class RainbowLeavesBlockColor implements BlockColor
	{
		@Override
		public int getColor(@NotNull BlockState state, BlockAndTintGetter worldIn, BlockPos pos, int tintIndex)
		{
			if (worldIn != null && pos != null)
			{
				int red = 0;
				int green = 0;
				int blue = 0;

				for (int i = -1; i <= 1; ++i)
				{
					for (int j = -1; j <= 1; ++j)
					{
						int averageColor = BiomeColors.getAverageFoliageColor(worldIn, pos);
						red += (averageColor & 16711680) >> 16;
						green += (averageColor & 65280) >> 8;
						blue += averageColor & 255;
					}
				}

				red = pos.getX() * 32 + pos.getY() * 16;
				if ((red & 256) != 0)
				{
					red = 255 - (red & 255);
				}
				red &= 255;

				blue = pos.getY() * 32 + pos.getZ() * 16;
				if ((blue & 256) != 0)
				{
					blue = 255 - (blue & 255);
				}
				blue ^= 255;

				green = pos.getX() * 16 + pos.getZ() * 32;
				if ((green & 256) != 0)
				{
					green = 255 - (green & 255);
				}
				green &= 255;

				return red << 16 | blue << 8 | green;
			}
			else return FoliageColor.getDefaultColor();
		}

	}
}
