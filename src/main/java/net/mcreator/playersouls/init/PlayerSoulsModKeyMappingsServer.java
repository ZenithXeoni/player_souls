
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playersouls.init;

import net.minecraft.resources.ResourceLocation;

import net.mcreator.playersouls.network.ReturnSoulMessage;
import net.mcreator.playersouls.network.KillSoulMessage;
import net.mcreator.playersouls.network.BanSoulMessage;
import net.mcreator.playersouls.PlayerSoulsMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayNetworking;

public class PlayerSoulsModKeyMappingsServer {
	public static void serverLoad() {
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(PlayerSoulsMod.MODID, "ban_soul"), BanSoulMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(PlayerSoulsMod.MODID, "kill_soul"), KillSoulMessage::apply);
		ServerPlayNetworking.registerGlobalReceiver(new ResourceLocation(PlayerSoulsMod.MODID, "return_soul"), ReturnSoulMessage::apply);
	}
}
