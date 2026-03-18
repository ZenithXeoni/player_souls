
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playersouls.init;

import net.minecraft.world.level.GameRules;

import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;

public class PlayerSoulsModGameRules {
	public static GameRules.Key<GameRules.IntegerValue> DAYSSOULISBANNED;
	public static GameRules.Key<GameRules.BooleanValue> ALLOW_SOUL_EXTRACTION;

	public static void load() {
		DAYSSOULISBANNED = GameRuleRegistry.register("dayssoulisbanned", GameRules.Category.PLAYER, GameRuleFactory.createIntRule(7));
		ALLOW_SOUL_EXTRACTION = GameRuleRegistry.register("allow_soul_extraction", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(true));
	}
}
