
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.playersouls.init;

import net.mcreator.playersouls.procedures.SoulInitializedProcedure;
import net.mcreator.playersouls.procedures.SoulIdentifyProcedure;
import net.mcreator.playersouls.procedures.ReturnSoulOnKeyPressedProcedure;
import net.mcreator.playersouls.procedures.KillSoulOnKeyPressedProcedure;
import net.mcreator.playersouls.procedures.ForceExtractSoulProcedureProcedure;
import net.mcreator.playersouls.procedures.ExtractSoulProcedureProcedure;
import net.mcreator.playersouls.procedures.ExtractSoulKillableProcedure;
import net.mcreator.playersouls.procedures.BanSoulOnKeyPressedProcedure;

@SuppressWarnings("InstantiationOfUtilityClass")
public class PlayerSoulsModProcedures {
	public static void load() {
		new ExtractSoulProcedureProcedure();
		new SoulIdentifyProcedure();
		new KillSoulOnKeyPressedProcedure();
		new BanSoulOnKeyPressedProcedure();
		new ReturnSoulOnKeyPressedProcedure();
		new ForceExtractSoulProcedureProcedure();
		new SoulInitializedProcedure();
		new ExtractSoulKillableProcedure();
	}
}
