
package net.mcreator.playersouls.command;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.commands.Commands;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandBuildContext;

import net.mcreator.playersouls.procedures.ForceExtractSoulProcedureProcedure;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.arguments.BoolArgumentType;
import com.mojang.brigadier.CommandDispatcher;

public class ForceExtractSoulCommand {
	public static void register(CommandDispatcher<CommandSourceStack> dispatcher, CommandBuildContext commandBuildContext) {
		dispatcher.register(
				Commands.literal("force_extract_soul").requires(s -> s.hasPermission(4)).then(Commands.argument("Display_name", StringArgumentType.word()).then(Commands.argument("Set_Soulless", BoolArgumentType.bool()).executes(arguments -> {
					ServerLevel world = arguments.getSource().getLevel();
					double x = arguments.getSource().getPosition().x();
					double y = arguments.getSource().getPosition().y();
					double z = arguments.getSource().getPosition().z();
					Entity entity = arguments.getSource().getEntity();
					Direction direction = entity.getDirection();

					ForceExtractSoulProcedureProcedure.execute(com.google.common.collect.ImmutableMap.<String, Object>builder().put("arguments", arguments).put("entity", entity).build());
					return 0;
				}))));
	}
}
