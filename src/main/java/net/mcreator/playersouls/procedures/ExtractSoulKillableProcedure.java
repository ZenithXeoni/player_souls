package net.mcreator.playersouls.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.network.chat.Component;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;

import net.mcreator.playersouls.init.PlayerSoulsModGameRules;
import net.mcreator.playersouls.PlayerSoulsMod;

import java.util.Map;

public class ExtractSoulKillableProcedure {

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				PlayerSoulsMod.LOGGER.warn("Failed to load dependency world for procedure ExtractSoulKillable!");
			return;
		}
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PlayerSoulsMod.LOGGER.warn("Failed to load dependency entity for procedure ExtractSoulKillable!");
			return;
		}
		LevelAccessor world = (LevelAccessor) dependencies.get("world");
		Entity entity = (Entity) dependencies.get("entity");
		if (world.getLevelData().getGameRules().getBoolean(PlayerSoulsModGameRules.ALLOW_SOUL_EXTRACTION)) {
			if (new Object() {
				public int getScore(String score, Entity _ent) {
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective(score);
					if (_so != null)
						return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
					return 0;
				}
			}.getScore("Soulless", entity) == 1) {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A7cYour soul has already been extracted"), false);
			} else {
				if (entity instanceof Player _player && !_player.level.isClientSide())
					_player.displayClientMessage(Component.literal("\u00A73Your soul has been extracted, be careful who you give this to."), false);
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null) {
						_ent.getServer().getCommands().performPrefixedCommand(
								new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level instanceof ServerLevel ? (ServerLevel) _ent.level : null, 4, _ent.getName().getString(), _ent.getDisplayName(),
										_ent.level.getServer(), _ent),
								("/give @s player_souls:player_soul{display:{Lore:['{\"text\":\"Attachted Soul: " + "" + entity.getScoreboardName() + "\",\"color\":\"dark_aqua\",\"italic\":true}']},SoulPresent:1b, SoulControl:1b," + "Damage:"
										+ (new Object() {
											public int getScore(String score, Entity _ent) {
												Scoreboard _sc = _ent.getLevel().getScoreboard();
												Objective _so = _sc.getObjective(score);
												if (_so != null)
													return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
												return 0;
											}
										}.getScore("SoulDamage", entity)) + ",PlayerSoul:\"" + entity.getScoreboardName() + "\"} 1"));
					}
				}
				{
					Entity _ent = entity;
					Scoreboard _sc = _ent.getLevel().getScoreboard();
					Objective _so = _sc.getObjective("Soulless");
					if (_so == null)
						_so = _sc.addObjective("Soulless", ObjectiveCriteria.DUMMY, Component.literal("Soulless"), ObjectiveCriteria.RenderType.INTEGER);
					_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
				}
			}
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(Component.literal("\u00A7cSoul Extraction has been disabled."), false);
		}
	}
}
