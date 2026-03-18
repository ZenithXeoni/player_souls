/*
 *	MCreator note:
 *
 *	If you lock base mod element files, you can edit this file and the proxy files
 *	and they won't get overwritten. If you change your mod package or modid, you
 *	need to apply these changes to this file MANUALLY.
 *
 *
 *	If you do not lock base mod element files in Workspace settings, this file
 *	will be REGENERATED on each build.
 *
 */
package net.mcreator.playersouls;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.mcreator.playersouls.init.PlayerSoulsModProcedures;
import net.mcreator.playersouls.init.PlayerSoulsModKeyMappingsServer;
import net.mcreator.playersouls.init.PlayerSoulsModItems;
import net.mcreator.playersouls.init.PlayerSoulsModGameRules;
import net.mcreator.playersouls.init.PlayerSoulsModCommands;

import net.fabricmc.api.ModInitializer;

public class PlayerSoulsMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "player_souls";

	@Override
	public void onInitialize() {
		LOGGER.info("Initializing PlayerSoulsMod");

		PlayerSoulsModGameRules.load();

		PlayerSoulsModItems.load();

		PlayerSoulsModProcedures.load();
		PlayerSoulsModCommands.load();

		PlayerSoulsModKeyMappingsServer.serverLoad();

	}
}
