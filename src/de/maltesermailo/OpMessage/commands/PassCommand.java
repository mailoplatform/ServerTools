package de.maltesermailo.OpMessage.commands;

import java.util.ArrayList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.maltesermailo.OpMessage.Core;

public class PassCommand implements CommandExecutor {

	private Core plugin;
	public PassCommand(Core plugin) {
		this.plugin = plugin;
	}
	private ArrayList<String> code = new ArrayList<String>();

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length > 1) {
			String[] codes = (String[]) plugin.cfg.get("codes");
			
		}
		
		
		
		
		return false;
	}

	
}
