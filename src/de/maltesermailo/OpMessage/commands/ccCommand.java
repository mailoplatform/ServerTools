package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import de.maltesermailo.OpMessage.Core;



public class ccCommand implements CommandExecutor {

	
	Core plugin;
	
	public ccCommand(Core main) {
		plugin = main;
	}
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs instanceof ConsoleCommandSender) {
			ChatClearPlayers(100, "Console");
		}
		if (cs instanceof Player) {
			Player p = (Player) cs;
		    if (p.hasPermission("cn.cc")) {
		    	ChatClearPlayers(100, p.getName());
		    } else {
		    	cs.sendMessage("§cInsufficient Permissions!");
		    }
		}
		
		
		
		
		
		return false;
	}
	public void ChatClearPlayers(int zeilen, String name) {
		for(int i = 0; i<=zeilen; i++) {
			plugin.getServer().broadcastMessage("");
			
		}
	plugin.getServer().broadcastMessage("§7The Chat cleared by "+ name);
	}

}
