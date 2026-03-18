package net.mcreator.playersouls.mixins;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.Mixin;

import net.minecraft.world.item.crafting.RepairItemRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.CraftingContainer;

import net.mcreator.playersouls.init.PlayerSoulsModItems;

import java.util.ArrayList;

import com.google.common.collect.Lists;

@Mixin(RepairItemRecipe.class)
public abstract class PlayerSoulsModRepairItemRecipeMixin {
	@Inject(method = "assemble", at = @At("HEAD"), cancellable = true)
	public void assemble(CraftingContainer craftingContainer, CallbackInfoReturnable<ItemStack> cir) {
		ItemStack itemStack3;
		ItemStack itemStack;
		ArrayList<ItemStack> list = Lists.newArrayList();
		for (int i = 0; i < craftingContainer.getContainerSize(); ++i) {
			ItemStack itemStack2;
			itemStack = craftingContainer.getItem(i);
			if (itemStack.isEmpty())
				continue;
			list.add(itemStack);
		}
		if ((itemStack3 = (ItemStack) list.get(0)).is((PlayerSoulsModItems.SUMMONNED_SOUL))) {
			cir.setReturnValue(ItemStack.EMPTY);
		}
		if ((itemStack3 = (ItemStack) list.get(0)).is((PlayerSoulsModItems.PLAYER_SOUL))) {
			cir.setReturnValue(ItemStack.EMPTY);
		}
	}
}
