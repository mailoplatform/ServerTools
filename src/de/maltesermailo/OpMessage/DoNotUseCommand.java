package de.maltesermailo.OpMessage;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class DoNotUseCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label,
			String[] args) {
		cs.sendMessage("§cDu darfst diesen Befehl nicht nutzen!");
		return false;
	}

}
