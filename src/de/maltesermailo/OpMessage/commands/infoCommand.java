package de.maltesermailo.OpMessage.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import de.maltesermailo.OpMessage.Core;

public class infoCommand implements CommandExecutor {
	private Core plugin;
	public infoCommand(Core plugin) {
		this.plugin = plugin;
	}

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (cs.hasPermission("cn.core")) {
			if (args.length == 0) {
				cs.sendMessage("§7For commands /craft help");
			} else {
				if (args[0].equalsIgnoreCase("info")) {
					cs.sendMessage("§7---§6" + Core.prefix + "§6Info" + Core.prefix + "§7---");
					cs.sendMessage("§7Name: §6" + this.plugin.getDescription().getName());
					cs.sendMessage("§7Developer " + "§6" + this.plugin.getDescription().getAuthors());
					cs.sendMessage("§7Version: " + "§6" + this.plugin.getDescription().getVersion());
					return false;
				} else if (args[0].equalsIgnoreCase("help")) {
					cs.sendMessage("§7---" + Core.prefix + "Commands:§7" + Core.prefix + "---");
					cs.sendMessage("§6/craft info §7- Plugin-Info");
					cs.sendMessage("§6/craft help §7- This Help");
					cs.sendMessage("§6/craft reload §7- Reload this Plugin");
					cs.sendMessage("§6/cc §7- Clears the Chat.");
					cs.sendMessage("§6/hilfe §7- Help Command for Servers");
					cs.sendMessage("§6/ban §c<player> [reason] §7- Bans a player (with a reason)");
					cs.sendMessage("§6/unban §c<player> §7- Unbans a player");
					cs.sendMessage("§6/fly §c<on/off> §7- Activates/Disables the fly mode");
					cs.sendMessage("§6/feed §c[player] §7- Feeds you or an another player");
					cs.sendMessage("§6/spawn §7- Teleports you to the spawn point");
					cs.sendMessage("§6/setspawn §7- Sets the spawn point");
				} else if(args[0].equalsIgnoreCase("reload")) {
					if (cs.hasPermission("opmessage.reload")) {
						this.plugin.getServer().getPluginManager().disablePlugin(this.plugin);
						this.plugin.getServer().getPluginManager().enablePlugin(this.plugin);
						cs.sendMessage(Core.prefix + "Reloaded CraftNetwork Plugin");
					}
				} else {
					cs.sendMessage("For help /craft help");
				}
			}
		} else {
			cs.sendMessage("§cInsufficient Permissions!");
		}
		
		return false;
	}
	
	

}
