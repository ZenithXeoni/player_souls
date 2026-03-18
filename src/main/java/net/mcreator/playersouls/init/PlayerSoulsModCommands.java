
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playersouls.init;

import net.mcreator.playersouls.command.ForceExtractSoulCommand;
import net.mcreator.playersouls.command.ExtractSoulCommand;

import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;

public class PlayerSoulsModCommands {
	public static void load() {
		CommandRegistrationCallback.EVENT.register((dispatcher, commandBuildContext, dedicated) -> {
			ForceExtractSoulCommand.register(dispatcher, commandBuildContext);
			ExtractSoulCommand.register(dispatcher, commandBuildContext);
		});
	}
}
