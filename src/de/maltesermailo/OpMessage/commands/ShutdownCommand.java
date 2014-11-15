package de.maltesermailo.OpMessage.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import de.maltesermailo.OpMessage.Core;

public class ShutdownCommand implements CommandExecutor {

	private Core plugin;
	public ShutdownCommand(Core plugin) {
		this.plugin = plugin;
	}
	public boolean used = false;
	private int currentTime = 60;
	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs.hasPermission("cn.shutdown")) {
			if (!used) {
				this.used = true;
				Bukkit.broadcastMessage("§7[§eREALM§7] Der Server fährt in 2 Minuten herunter!");
				Bukkit.getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
					@Override
					public void run() {
						Bukkit.broadcastMessage("§7[§eREALM§7] Der Server fährt in 1 Minute herunter!");
						currentTime = currentTime -50;
					}
				}, 60*20L);
				Bukkit.getScheduler().scheduleSyncRepeatingTask(this.plugin, new Runnable() {
					@Override
					public void run() {
						Bukkit.broadcastMessage("§7[§eREALM§7] Der Server fährt in " + currentTime + " Sekunden herunter!");
						currentTime--;
						if (currentTime == 0) {
							Bukkit.shutdown();
						}
					}
				}, 110*20L, 1*20L);
			} else {
				 cs.sendMessage("Fehler, der Server wird bereits heruntergefahren!");
			}
		}
		return false;
	}

}
