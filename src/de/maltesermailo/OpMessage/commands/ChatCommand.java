package de.maltesermailo.OpMessage.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.maltesermailo.OpMessage.Core;

public class ChatCommand implements CommandExecutor {

	private Core plugin;
	public ChatCommand(Core plugin) {
		this.plugin = plugin;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("disable")) {
				if (cs.hasPermission("cn.chat.disable")) {
					if (plugin.chatEnabled == false) {
						cs.sendMessage("§l§cDer Chat war bereits deaktiviert!");
						return true;
					}
					plugin.chatEnabled = false;
					Bukkit.broadcastMessage("§l§cDER CHAT WURDE DEAKTIVIERT!");
				}
			} else if (args[0].equalsIgnoreCase("enable")) {
				if (cs.hasPermission("cn.chat.enable")) {
					if (plugin.chatEnabled == true) {
						cs.sendMessage("§l§cDer Chat war bereits aktiviert!");
						return true;
					}
					plugin.chatEnabled = true;
					Bukkit.broadcastMessage("§l§2DER CHAT WURDE AKTIVIERT!");
				}
			}
		} else {
			cs.sendMessage("§7/chat disable - Disable the Chat");
			cs.sendMessage("§7/chat enable - Enable the Chat");
		}
		
		
		
		
		
		return false;
	}

}
