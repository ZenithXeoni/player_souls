
package net.mcreator.playersouls.command;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandBuildContext;

import net.mcreator.playersouls.procedures.ForceExtractSoulProcedureProcedure;
import net.mcreator.playersouls.procedures.ExtractSoulKillableProcedure;

import com.mojang.brigadier.CommandDispatcher;

public class ExtractSoulCommand {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext commandBuildContext) {
		dispatcher.register(Commands.literal("extract_soul")

				.then(Commands.literal("Alllow_Killing").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					Direction direction = entity.getDirection();

					ExtractSoulKillableProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("world", world).put("entity", entity).build());
					return 0;
				})).then(Commands.literal("Disable_Killing").executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					Direction direction = entity.getDirection();

					ForceExtractSoulProcedureProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("arguments", arguments).put("entity", entity).build());
					return 0;
				})));
	}
}
