package dev.thomasglasser.aliysium.rainbowoaks.data.recipes;

import dev.thomasglasser.aliysium.rainbowoaks.RainbowOaks;
import dev.thomasglasser.aliysium.rainbowoaks.data.tags.RainbowOaksItemTagsProvider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class RainbowOaksRecipes extends RecipeProvider
{
	public RainbowOaksRecipes(PackOutput pOutput)
	{
		super(pOutput);
	}

	@Override
	protected void buildRecipes(Consumer<FinishedRecipe> pWriter)
	{
		ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, Items.OAK_PLANKS, 4).requires(RainbowOaksItemTagsProvider.RAINBOW_LOGS).group("planks").unlockedBy("has_logs", has(RainbowOaksItemTagsProvider.RAINBOW_LOGS)).save(pWriter, RainbowOaks.modLoc("oak_planks_from_rainbow_logs"));
	}
}
