package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class GCCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs.hasPermission("cn.gc")) {
		 cs.sendMessage("§7Maximaler Arbeitsspeicher:§6 " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + " MB");
		 cs.sendMessage("§7Verwendeter Arbeitsspeicher:§6 " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + " MB");
		 cs.sendMessage("§7Freier Arbeitsspeicher:§6 " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + " MB");
		}
		return false;
	}

}
