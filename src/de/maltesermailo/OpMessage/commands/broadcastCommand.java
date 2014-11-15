package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.maltesermailo.OpMessage.Core;

public class broadcastCommand implements CommandExecutor {

	Core plugin;
	public broadcastCommand(Core main) {
		plugin = main;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		broadcastMessageLoader(null);
		return false;
	}
	public void broadcastMessageLoader(String[] message1) {
		plugin.getServer().broadcast(null, null);
	}

}
