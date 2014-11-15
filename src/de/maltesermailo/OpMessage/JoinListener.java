package de.maltesermailo.OpMessage;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinListener implements Listener {
	private Core plugin;
	public JoinListener(Core plugin) {
		this.plugin = plugin;
	}



	@EventHandler (priority = EventPriority.HIGHEST)
	public void onJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		File file = new File("plugins//OpMessage//spawn.yml");
		YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		  Location loc = p.getLocation();
		  double x = cfg.getDouble("X");
		  double y = cfg.getDouble("Y");
		  double z = cfg.getDouble("Z");
		  double yaw = cfg.getDouble("Yaw");
		  double pitch = cfg.getDouble("Pitch");
		  String worldname = cfg.getString("Worldname");
		  
		  World welt = Bukkit.getWorld(worldname);
		  
		  loc.setX(x);
		  loc.setY(y);
		  loc.setZ(z);
		  loc.setYaw((float) yaw);
		  loc.setPitch((float) pitch);
		  loc.setWorld(welt);
		  e.getPlayer().teleport(loc);
		if (p.isOp()) {
			e.setJoinMessage(null);
		
		} else {
			e.setJoinMessage(null);
		}
		for (String msg : this.plugin.getConfig().getStringList("opmessage.join")) {
			if (this.plugin.getConfig().getBoolean("opmessage.join.showname")) {
				e.setJoinMessage("§6[" + e.getPlayer().getName() + "]" + msg);
			} else {
				e.setJoinMessage(msg);
			}
		}
		
	}
	@EventHandler  (priority = EventPriority.HIGHEST)
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		if (p.isOp()) {
			e.setQuitMessage(null);
		
		} else {
			e.setQuitMessage(null);
		}
		for (String msg : this.plugin.getConfig().getStringList("opmessage.quit")) {
			p.sendMessage(msg);
		}
		
		
	}
}