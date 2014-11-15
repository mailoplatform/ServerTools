package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.maltesermailo.OpMessage.Core;

public class hilfeCommand implements CommandExecutor {
	
	private Core plugin;
	public hilfeCommand(Core plugin) {
		this.plugin = plugin;
	}
	

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		
		
		
		if (args.length < 1)
			for (String msg : this.plugin.getConfig().getStringList("hilfebefehl.hilfetext")) {
				cs.sendMessage(msg);
			}

		return false;
	}

	
	
	
}
