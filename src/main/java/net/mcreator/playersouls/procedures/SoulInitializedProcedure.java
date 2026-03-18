package net.mcreator.playersouls.procedures;

import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.mcreator.playersouls.PlayerSoulsMod;

import net.fabricmc.fabric.api.networking.v1.ServerPlayConnectionEvents;

import java.util.Map;
import java.util.HashMap;

public class SoulInitializedProcedure {
	public SoulInitializedProcedure() {
		ServerPlayConnectionEvents.JOIN.register((handler, sender, server) -> {
			Map<String, Object> dependencies = new HashMap<>();
			dependencies.put("entity", handler.getPlayer());
			dependencies.put("x", handler.getPlayer().getX());
			dependencies.put("y", handler.getPlayer().getY());
			dependencies.put("z", handler.getPlayer().getZ());
			dependencies.put("world", handler.getPlayer().getLevel());
			execute(dependencies);
		});
	}

	public static void execute(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				PlayerSoulsMod.LOGGER.warn("Failed to load dependency entity for procedure SoulInitialized!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (new Object() {
			public int getScore(String score, Entity _ent) {
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective(score);
				if (_so != null)
					return _sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).getScore();
				return 0;
			}
		}.getScore("Soul_Intitalized", entity) == 1) {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Soul_Intitalized");
				if (_so == null)
					_so = _sc.addObjective("Soul_Intitalized", ObjectiveCriteria.DUMMY, Component.literal("Soul_Intitalized"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
			}
		} else {
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("Soul_Intitalized");
				if (_so == null)
					_so = _sc.addObjective("Soul_Intitalized", ObjectiveCriteria.DUMMY, Component.literal("Soul_Intitalized"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(1);
			}
			{
				Entity _ent = entity;
				Scoreboard _sc = _ent.getLevel().getScoreboard();
				Objective _so = _sc.getObjective("SoulDamage");
				if (_so == null)
					_so = _sc.addObjective("SoulDamage", ObjectiveCriteria.DUMMY, Component.literal("SoulDamage"), ObjectiveCriteria.RenderType.INTEGER);
				_sc.getOrCreatePlayerScore(_ent.getScoreboardName(), _so).setScore(0);
			}
		}
	}
}
