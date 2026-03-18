
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playersouls.init;

import org.lwjgl.glfw.GLFW;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.KeyMapping;

import net.mcreator.playersouls.network.ReturnSoulMessage;
import net.mcreator.playersouls.network.KillSoulMessage;
import net.mcreator.playersouls.network.BanSoulMessage;
import net.mcreator.playersouls.PlayerSoulsMod;

import net.fabricmc.fabric.api.client.networking.v1.ClientPlayNetworking;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import com.mojang.blaze3d.platform.InputConstants;

public class PlayerSoulsModKeyMappings {
	public static class PlayerSoulsModKeyMapping extends KeyMapping {
		private boolean isDownOld;

		public PlayerSoulsModKeyMapping(String string, int i, String string2) {
			super(string, InputConstants.Type.KEYSYM, i, string2);
		}

		public int action() {
			if (isDownOld != isDown() && isDown()) {
				isDownOld = isDown();
				return 1;
			} else if (isDownOld != isDown() && !isDown()) {
				isDownOld = isDown();
				return 2;
			}
			isDownOld = isDown();
			return 0;
		}
	}

	public static PlayerSoulsModKeyMapping BAN_SOUL = (PlayerSoulsModKeyMapping) KeyBindingHelper.registerKeyBinding(new PlayerSoulsModKeyMapping("key.player_souls.ban_soul", GLFW.GLFW_KEY_KP_2, "key.categories.soulactions"));
	public static PlayerSoulsModKeyMapping KILL_SOUL = (PlayerSoulsModKeyMapping) KeyBindingHelper.registerKeyBinding(new PlayerSoulsModKeyMapping("key.player_souls.kill_soul", GLFW.GLFW_KEY_KP_1, "key.categories.soulactions"));
	public static PlayerSoulsModKeyMapping RETURN_SOUL = (PlayerSoulsModKeyMapping) KeyBindingHelper.registerKeyBinding(new PlayerSoulsModKeyMapping("key.player_souls.return_soul", GLFW.GLFW_KEY_KP_3, "key.categories.soulactions"));

	public static void load() {
		ClientTickEvents.END_CLIENT_TICK.register((client) -> {
			int BAN_SOULaction = BAN_SOUL.action();
			if (BAN_SOULaction == 1) {
				ClientPlayNetworking.send(new ResourceLocation(PlayerSoulsMod.MODID, "ban_soul"), new BanSoulMessage(true, false));
			} else if (BAN_SOULaction == 2) {
				ClientPlayNetworking.send(new ResourceLocation(PlayerSoulsMod.MODID, "ban_soul"), new BanSoulMessage(false, true));
			}
			int KILL_SOULaction = KILL_SOUL.action();
			if (KILL_SOULaction == 1) {
				ClientPlayNetworking.send(new ResourceLocation(PlayerSoulsMod.MODID, "kill_soul"), new KillSoulMessage(true, false));
			} else if (KILL_SOULaction == 2) {
				ClientPlayNetworking.send(new ResourceLocation(PlayerSoulsMod.MODID, "kill_soul"), new KillSoulMessage(false, true));
			}
			int RETURN_SOULaction = RETURN_SOUL.action();
			if (RETURN_SOULaction == 1) {
				ClientPlayNetworking.send(new ResourceLocation(PlayerSoulsMod.MODID, "return_soul"), new ReturnSoulMessage(true, false));
			} else if (RETURN_SOULaction == 2) {
				ClientPlayNetworking.send(new ResourceLocation(PlayerSoulsMod.MODID, "return_soul"), new ReturnSoulMessage(false, true));
			}
		});
	}
}
