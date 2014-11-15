package de.maltesermailo.OpMessage;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import de.maltesermailo.OpMessage.commands.*;

public class Core extends JavaPlugin {
	private int messageTask;
	public File file = new File("plugins/CraftNetwork/codes.yml");
	public FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static String prefix = "§7[§4!§7]: ";
	public boolean chatEnabled = true;

	public void onEnable() {
		//Insgesamt hat das Pl 1412 Zeilen
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new JoinListener(this), this);
		pm.registerEvents(new PlayerListener(), this);
		this.getCommand("craft").setExecutor(new infoCommand(this));
		this.getCommand("hilfe").setExecutor(new hilfeCommand(this));
		this.getCommand("feed").setExecutor(new feedCommand());
		this.getCommand("fly").setExecutor(new flyCommand());
		pm.registerEvents(new ChatListener(this), this);
		pm.registerEvents(new RespawnListener(), this);
		this.getCommand("cc").setExecutor(new ccCommand(this));
		this.getCommand("spawn").setExecutor(new spawnCommand());
		this.getCommand("setspawn").setExecutor(new setspawnCommand());
		this.getCommand("vanish").setExecutor(new VanishCommand());
		this.getCommand("gc").setExecutor(new GCCommand());
		this.getCommand("kill").setExecutor(new KillCommand());
		this.getCommand("shutdown").setExecutor(new ShutdownCommand(this));
		this.getCommand("afk").setExecutor(new AFKCommand());
		this.getCommand("msg").setExecutor(new MSGCmd());
		this.getCommand("sign").setExecutor(new SignCommand());
		this.getCommand("kopf").setExecutor(new kopfCommand());
		this.getCommand("donotuse").setExecutor(new DoNotUseCommand());
		this.getConfig().addDefault("automsg.enable", true);
		this.getConfig().addDefault("wartung.enable", false);
		this.getCommand("chat").setExecutor(new ChatCommand(this));
		this.getCommand("lightning").setExecutor(new LightningCmd());
		this.getConfig().addDefault("messages", new String[] {
			"OpMessage",
			"Plugin by maltesermailo",
			"Gutes Plugin oder?"
		});
		if (this.getConfig().getBoolean("automsg.enable", true)) {
			this.messageTask = Bukkit.getScheduler().scheduleSyncRepeatingTask(this, new MessageRunnable(this.getConfig().getStringList("messages")), 45L, 45*20L);
		} else {
		}
		System.out.println (this.getDescription().getName() + " " + this.getDescription().getVersion() + " wurde aktiviert");
		this.getConfig().addDefault("opmessage.join", new String[] {
	    		""
	    });
		this.getConfig().addDefault("opmessage.quit", new String[] {
	    		""
	    });
		this.getConfig().addDefault("hilfebefehl.hilfetext", new String[] {
	    		"In the config.yml under hilfebefehl.hilfetext must be more lines for the help. Please contact an administrator if you are an Player"
	    });
		this.getConfig().addDefault("opmessage.op.playerthereop", new String[] {
	    		"§6Opped"
	    });
		this.getConfig().addDefault("opmessage.op.playertherenotop", new String[] {
	    		"§4You are now OP"
	    });
		this.getConfig().addDefault("opmessage.op.playerthereopsuffix", new String[] {
	    		""
	    });
		this.getConfig().addDefault("opmessage.deop.playerthereopsuffix", new String[] {
	    		"§6are no longer OP"
	    });
		this.getConfig().addDefault("opmessage.deop.playerthereop", new String[] {
	    		"§6"
	    });
		this.getConfig().addDefault("opmessage.deop.playertherenotop", new String[] {
	    		"§4You are no longer OP"
	    });
		this.getConfig().addDefault("useless", new String[] {
	    		" "
	    });
		this.getConfig().addDefault("opmessage.join.showname", true);
	    this.getConfig().options().copyDefaults(true);
	    if (!file.exists()) {
	    	try {
				file.createNewFile();
			} catch (IOException e) {
				System.out.println("Codes.yml konnte nicht erstellt werden deaktiviere PassCommand");
			}
	    }
	    //this.getCommand("pass").setExecutor(new PassCommand(this));
	    this.saveConfig();
	}
	
	public void onDisable() {
		System.out.println (this.getDescription().getName() + " " + this.getDescription().getVersion() + " wurde deaktiviert");
		Bukkit.getScheduler().cancelTask(this.messageTask);
	}
	
	
	
}
