package de.maltesermailo.OpMessage.commands;

import java.io.File;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class spawnCommand implements CommandExecutor{

 @Override
 public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
  if(!(cs instanceof Player)) {
   System.out.println("Du kannst als Console dich nicht zum Spawn teleportieren!");
   return true;
  } 
  
  Player p = (Player) cs;
  
  if(!p.hasPermission("cn.spawn")) {
   p.sendMessage("§cInsufficent Permissions!");
   return true;
  }
  
  File file = new File("plugins//OpMessage//spawn.yml");
  if(!file.exists()) {
   p.sendMessage("§cEs wurde noch kein Spawn gesetzt!");
   return true;
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
  
  return true;
 }

}