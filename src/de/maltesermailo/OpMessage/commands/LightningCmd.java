package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LightningCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (args.length < 1 && cs.hasPermission("cn.strike") && cs instanceof Player) {
			Player p = (Player) cs;
			p.getWorld().strikeLightning(p.getTargetBlock(null, 600).getLocation());
		}
		
		
		return false;
	}

}
