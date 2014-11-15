package de.maltesermailo.OpMessage;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

public class ScoreboardListener implements Listener {
@EventHandler
public void onPreLogin(PlayerLoginEvent e) {
	if (e.getPlayer().hasPermission("cn.ownertab")) {
		if (!e.getPlayer().getScoreboard().getTeam("Owner").hasPlayer(e.getPlayer())) {
			e.getPlayer().getScoreboard().getTeam("Owner").addPlayer(e.getPlayer());
		}
	} else if (e.getPlayer().hasPermission("cn.modtab")) {
		if (!e.getPlayer().getScoreboard().getTeam("Moderator").hasPlayer(e.getPlayer())) {
			e.getPlayer().getScoreboard().getTeam("Moderator").addPlayer(e.getPlayer());
		}
	} else if (e.getPlayer().isOp()) {
		if (!e.getPlayer().getScoreboard().getTeam("OP").hasPlayer(e.getPlayer())) {
			e.getPlayer().getScoreboard().getTeam("OP").addPlayer(e.getPlayer());
			e.getPlayer().sendMessage("This is a test!");
		}
	}
}
}

