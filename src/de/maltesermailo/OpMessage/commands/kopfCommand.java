package de.maltesermailo.OpMessage.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

public class kopfCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		if (!(cs instanceof Player)) {
			cs.sendMessage("§cDu musst ein Spieler sein");
			return true;
		}
		if (args.length == 1) {
			Player p = (Player) cs;
			if (p.hasPermission("cn.kopf")) {
				Inventory inv = p.getInventory();
				ItemStack item = new ItemStack(Material.SKULL_ITEM, 1, (byte) 3);
				SkullMeta meta_Skull = (SkullMeta) item.getItemMeta();
				meta_Skull.setOwner(args[0]);
				meta_Skull.setDisplayName("§cKopf von" + meta_Skull.getOwner());
				item.setItemMeta(meta_Skull);
				inv.addItem(item);
				
			}
		}
		return false;
	}

}
