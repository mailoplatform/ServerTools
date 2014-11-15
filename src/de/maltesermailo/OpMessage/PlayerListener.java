package de.maltesermailo.OpMessage;


import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class PlayerListener implements Listener {

	Location center;
	final int max = 30;
	@EventHandler
	public void onInteract(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (e.getPlayer().hasPermission("gb.fly")) {
				if (p.getItemInHand().getType() == Material.FEATHER) {
					if (p.getAllowFlight()) {
						p.setAllowFlight(false);
						p.setFlying(false);
						p.sendMessage("Du kannst nun nicht mehr fliegen!");
					} else {
						p.setAllowFlight(true);
						p.setFlying(true);
						p.sendMessage("Du kannst nun fliegen!");
						p.setFoodLevel(p.getFoodLevel() - 5);
					}
				}
			}
			
		} 
		if (p.hasPermission("gb.klasse2")) {
			if (p.getItemInHand().getType() == Material.ENDER_PEARL && p.getItemInHand().getAmount() < 64) {
				p.getItemInHand().setAmount(64);
			}
		}
		if (p.hasPermission("gb.klasse3")) {
			if (p.getItemInHand().getType() == Material.WORKBENCH) {
				if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
					p.openWorkbench(p.getLocation(), true);
					e.setCancelled(true);
				}
			}
		}
		if (p.hasPermission("gb.klasse4")) {
			
		}
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.EYE_OF_ENDER) {
					  
					  if(!p.hasPermission("cn.spawn")) {
					   p.sendMessage("§cInsufficent Permissions!");
					   return;
					  }
					  
					  File file = new File("plugins//OpMessage//spawn.yml");
					  if(!file.exists()) {
					   p.sendMessage("§cEs wurde noch kein Spawn gesetzt!");
					   return;
					  }
					  
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
					  
					  p.teleport(loc);
					  p.sendMessage("§7Du wurdest zum §6Spawn §7teleportiert.");
					  e.setCancelled(true);
			}
		}
		if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (p.getItemInHand().getType() == Material.ENDER_PEARL) {
				p.setVelocity(p.getLocation().getDirection().multiply(1.5));
				e.setCancelled(true);
			}
		}
		
		}
	public long onFly() {
		return 0;
	}
	@EventHandler
	public void onTree(BlockBreakEvent e) {
		Player p = e.getPlayer();
		if (e.getBlock().getType() == Material.LEAVES) {
			p.getInventory().addItem(new ItemStack(Material.APPLE, 2));
		
		}
		
	}
	@EventHandler
	public void onFall(EntityDamageEvent e) {
		if (e.getEntityType() == EntityType.PLAYER) {
			e.getEntity().setFallDistance(0.0F);
			if (e.getCause().equals(DamageCause.FALL)) {
				Player p = (Player) e.getEntity();
				p.playSound(p.getLocation(), Sound.ENDERMAN_TELEPORT, (float) 1, (float) 1);
				e.setCancelled(true);
				p.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, null);
			}
		}
	}
	@EventHandler
	public void onCommand(PlayerCommandPreprocessEvent e) {
		if (!e.getPlayer().hasPermission("cn.usecommands")) {
			if (e.getMessage().equalsIgnoreCase("/craft help") | e.getMessage().equalsIgnoreCase("/craft") | e.getMessage().equalsIgnoreCase("/craft support") | e.getMessage().equalsIgnoreCase("/donotuse") | e.getMessage().equalsIgnoreCase("/bw leave") | e.getMessage().equalsIgnoreCase("/spawn")) {
				e.setMessage(e.getMessage());
			} else {
				Player cs = e.getPlayer();
				cs.sendMessage(e.getMessage());
				e.setMessage("/donotuse");
			}
		}
	}
}
