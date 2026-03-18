
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playersouls.init;

import net.minecraft.world.item.Item;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Registry;

import net.mcreator.playersouls.item.SummonnedSoulItem;
import net.mcreator.playersouls.item.PlayerSoulItem;
import net.mcreator.playersouls.PlayerSoulsMod;

public class PlayerSoulsModItems {
	public static Item SUMMONNED_SOUL;
	public static Item PLAYER_SOUL;

	public static void load() {
		SUMMONNED_SOUL = Registry.register(Registry.ITEM, new ResourceLocation(PlayerSoulsMod.MODID, "summonned_soul"), new SummonnedSoulItem());
		PLAYER_SOUL = Registry.register(Registry.ITEM, new ResourceLocation(PlayerSoulsMod.MODID, "player_soul"), new PlayerSoulItem());
	}
}
