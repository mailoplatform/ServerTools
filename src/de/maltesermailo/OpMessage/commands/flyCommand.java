package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class flyCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = null;
		if (label.equalsIgnoreCase("fly")) {
			if (args.length == 0) {
				if (cs instanceof Player) {
					p = (Player) cs;
					if (p.hasPermission("cn.fly")) {
						if (!p.getAllowFlight()) {
							p.setAllowFlight(true);
							p.setFallDistance(0f);
							p.setFlying(true);
							p.sendMessage("§7Du hast nun Fly Mode!");
						} else {
							p.setAllowFlight(false);
							p.setFlying(false);
							p.sendMessage("§7Du hast nun keinen Fly Mode mehr!");
						}
					} else {
						cs.sendMessage("§cKeine Permissions zum Fliegen!");;
					}
				} else {
					cs.sendMessage("Die Konsole darf nicht fliegen!");
				}
		}
		} else
		if (label.equalsIgnoreCase("flyspeed")) {
			if (args.length == 1) {
				if (cs instanceof Player) {
					p = (Player) cs;
					if (p.hasPermission("cn.fly.speed")) {
						if (args[0].equalsIgnoreCase("1")) {
							p.setFlySpeed((float) 0.1);
						} else if (args[0].equalsIgnoreCase("2")) {
							p.setFlySpeed((float) 0.2);
						} else if (args[0].equalsIgnoreCase("3")) {
							p.setFlySpeed((float) 0.4);
						} else {
							p.sendMessage("§c/flyspeed 1|2|3");
						}
					}
				}	
			} else {
				if (!(cs instanceof Player)) {
					cs.sendMessage("Konsolen dürfen nicht fliegen");
					return true;
				}
				p = (Player) cs;
				p.sendMessage("§c/flyspeed 1|2|3");
			}
		}
		return false;
	}

}
