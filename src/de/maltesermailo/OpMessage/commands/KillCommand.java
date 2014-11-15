package de.maltesermailo.OpMessage.commands;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCommand implements CommandExecutor{
 @SuppressWarnings("deprecation")
 @Override
 public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
  if (cs.hasPermission("cn.kill")) {
   Player p = null;
   if (args.length == 0) {
    if (cs instanceof Player) {
     p = (Player) cs;
    } else {
     cs.sendMessage("§cDu kannst dich als Console nicht töten.");
     return true;
    }
   } else {
    String name = args[0];
    p = Bukkit.getPlayer(name);
    
    
   }
   if (p == null) {
    cs.sendMessage("§7Der Spieler ist nicht online!");
    return true;
   }
   p.setHealth(0);
   if (p != cs) {
    cs.sendMessage("§7Du hast §6" + p.getName() + "§7 getötet.");
    p.sendMessage("§7Du wurdest von §6" + cs.getName() + " §7getötet.");
   } else {
    p.sendMessage("§7Du hast dich getötet.");
   }
   return true;
  } else {
   cs.sendMessage("§cInsufficent Permissions!");
  }
  return true;
 }

}
