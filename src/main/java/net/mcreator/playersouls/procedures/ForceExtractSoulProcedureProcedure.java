package net.mcreator.playersouls.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.playersouls.PlayerSoulsMod;

import java.util.Map;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;

public class ForceExtractSoulProcedureProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("arguments") == null) {
			if (!dependencies.containsKey("arguments"))
				PlayerSoulsMod.LOGGER.warn("Failed to load dependency arguments for procedure ForceExtractSoulProcedure!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PlayerSoulsMod.LOGGER.warn("Failed to load dependency entity for procedure ForceExtractSoulProcedure!");
			return;
		}
		CommandContext<CommandSourceStack> arguments = (CommandContext<CommandSourceStack>) dependencies.get("arguments");
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof Player _player && !_player.level.isClientSide())
			_player.displayClientMessage(Component.literal("\u00A75You have summonned a soul, be careful with what you do."), false);
		{
			Entity _ent = entity;
			if (!_ent.level.isClientSide() && _ent.getServer() != null) {
				_ent.getServer().getCommands().performPrefixedCommand(
						new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
								_ent.level.getServer(), _ent),
						("/give @s player_souls:summonned_soul{display:{Lore:['{\"text\":\"Attachted Soul: " + "" + StringArgumentType.getString(arguments, "Display_name")
								+ "\",\"color\":\"dark_aqua\",\"italic\":true}']},SoulPresent:1b,SoulControl:1b,PlayerSoul:\"" + StringArgumentType.getString(arguments, "Display_name") + "\"} 1"));
			}
		}
		if (BoolArgumentType.getBool(arguments, "Set_Soulless")) {
			{
				Entity _ent = entity;
				if (!_ent.level.isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level.getServer(), _ent), ("/scoreboard players set " + StringArgumentType.getString(arguments, "Display_name") + " Soulless 1"));
				}
			}
		}
	}
}
