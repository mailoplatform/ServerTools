package de.maltesermailo.OpMessage.commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.maltesermailo.OpMessage.event.AFKToggleEvent;

public class AFKCommand implements CommandExecutor{

	private List<String> afk = new ArrayList<String>();
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) {
			cs.sendMessage("Fehler!");
			return true;
		}
		boolean wasAFK = this.afk.contains(cs.getName());
		boolean toAFK = !wasAFK;
		String message = null;
		if (args.length > 0) {
			message = args[0];
			for (int i = 1; i < args.length; i++) {
				message += " " + args[i];
			}
		}
		AFKToggleEvent event = new AFKToggleEvent((Player) cs, wasAFK, toAFK, message);
		Bukkit.getPluginManager().callEvent(event);
		if (event.wasAFK() != event.toAFK()) {
			Player p = event.getPlayer();
			if (event.toAFK()) {
				this.afk.add(p.getName());
				Bukkit.broadcastMessage("§7" + p.getName() + " ist jetzt AFK" + event.getMessage() != null ? "§7(" + event.getMessage() + "§7)." : ".");
			} else {
				Bukkit.broadcastMessage("§7" + p.getName() + " ist nicht länger AFK");
				this.afk.add(p.getName());
			}
		}
		return false;
	}


}
