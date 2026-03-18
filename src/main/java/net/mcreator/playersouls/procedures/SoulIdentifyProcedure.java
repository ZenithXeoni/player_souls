package net.mcreator.playersouls.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.network.chat.Component;

import net.mcreator.playersouls.PlayerSoulsMod;

import net.fabricmc.fabric.api.event.player.UseItemCallback;

import java.util.Map;
import java.util.HashMap;

public class SoulIdentifyProcedure {
	public SoulIdentifyProcedure() {
		UseItemCallback.EVENT.register((player, level, hand) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("world", level);
			dependencies.put("entity", player);
			dependencies.put("x", player.getX());
			dependencies.put("y", player.getY());
			dependencies.put("z", player.getZ());
			execute(dependencies);
			return InteractionResultHolder.pass(player.getItemInHand(hand));
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PlayerSoulsMod.LOGGER.warn("Failed to load dependency entity for procedure SoulIdentify!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getBoolean("SoulPresent")) {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal(("Attachted Soul: " + ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getOrCreateTag().getString("PlayerSoul")))), true);
		}
	}
}
