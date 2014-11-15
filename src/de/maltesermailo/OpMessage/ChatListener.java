package de.maltesermailo.OpMessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ChatListener implements Listener {
	private Core plugin;
	public ChatListener(Core plugin) {
		this.plugin = plugin;
	}
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		if (e.getMessage().startsWith("@")) {
			for (Player p : Bukkit.getOnlinePlayers()) {
				if (e.getMessage().startsWith("@" + p.getName())) {
					p.sendMessage(e.getMessage());
				}
			}
			return;
		}
			if (e.getPlayer().hasPermission("chat.color")) {
				e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
			}
			e.setFormat("§e%1$s: §f%2$s");
			if (e.getPlayer().hasPermission("chat.admin")) {
				e.setFormat("§4%1$s§f: §f%2$s");
			} else if (e.getPlayer().hasPermission("chat.moderator")) {
				e.setFormat("§c%1$s§f: %2$s");
			} else if (e.getPlayer().hasPermission("chat.player")) {
				e.setFormat("§7%1$s§f: %2$s");
			} else if (e.getPlayer().hasPermission("chat.premium")) {
				e.setFormat("§6%1$s§f: %2$s");
			} else if (e.getPlayer().hasPermission("chat.youtuber")) {
				e.setFormat("§5%1$s§f: %2$s");
			} else if (e.getPlayer().hasPermission("chat.hero")) {
				e.setFormat("§e%1$s§f: %2$s");
			} else if (e.getPlayer().hasPermission("chat.builder")) {
				e.setFormat("§a%1$s§f: %2$s");
				e.getPlayer().getScoreboard().getTeam("Builder").addPlayer(e.getPlayer());
			} else if (e.getPlayer().hasPermission("chat.supporter")) {
				e.setFormat("§b%1$s§f: %2$s");
				e.getPlayer().getScoreboard().getTeam("Supporter").addPlayer(e.getPlayer());
			} else if (e.getPlayer().hasPermission("chat.entwickler")) {
				e.setFormat("§b%1$s§f: %2$s");
			}
			if (e.getPlayer().isOp()) {
				e.setFormat("§4§l%1$s§f: §f%2$s");
			}
			if (!plugin.chatEnabled) {
				e.setCancelled(true);
				e.getPlayer().sendMessage("§7Der Chat ist deaktiviert!");
			} else {
				e.setCancelled(false);
			}
	}
}
