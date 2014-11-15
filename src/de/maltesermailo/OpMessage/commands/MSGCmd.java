package de.maltesermailo.OpMessage.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MSGCmd implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length > 1) {
			Player p = Bukkit.getPlayer(args[0]);
			if (!(p != null)) {
				cs.sendMessage("§cDer Name ist zu lang oder der Spieler offline!");
				return true;
			}
		}
		
		
		return false;
	}

}
