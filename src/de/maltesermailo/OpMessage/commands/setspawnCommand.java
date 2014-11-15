package de.maltesermailo.OpMessage.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class setspawnCommand implements CommandExecutor{

 @Override
 public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
  
  if(!(cs instanceof Player)) {
   System.out.println("Du kannst als Console den Spawn nicht setzen!");
   return true;
  } 
  Player p = (Player) cs;
  if(!p.hasPermission("cn.setspawn")) {
   p.sendMessage("§cInsufficent Permissions");
   return true;
  }
  File ordner = new File("plugins//OpMessage");
  File file = new File("plugins//OpMessage//spawn.yml");
  if(!ordner.exists()) {
   ordner.mkdir();
  }
  if(!file.exists()) {
   try {
    file.createNewFile(); 
   } catch(IOException e) {
    p.sendMessage("§cDie Datei konnte nicht erstellt werden!");
   }
  }
  YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
  Location loc = p.getLocation();
  
  double x = loc.getX();
  double y = loc.getY();
  double z = loc.getZ();
  double yaw = loc.getYaw();
  double pitch = loc.getPitch();
  String worldname = loc.getWorld().getName();
  
  cfg.set("X", x);
  cfg.set("Y", y);
  cfg.set("Z", z);
  cfg.set("Yaw", yaw);
  cfg.set("Pitch", pitch);
  cfg.set("Worldname", worldname);
  
  try {
   cfg.save(file);
  } catch (IOException e) {
   e.printStackTrace();
  }
  p.sendMessage("§7Du hast den §6Spawn§7 gesetzt.");
  return true;
 }

}