package adelie.plugins.party.YMLS;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;

import adelie.plugins.party.Party;

public class Files {
	
private Files() { }
	
	static Files instance = new Files();
	
	public static Files getInstance() {
		return instance;
	}
	
	Plugin p;
	
	FileConfiguration partys;
	File partyile;
	
	public void setup(Plugin p) {
		this.p = p;
		
		if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		
		partyile = new File(p.getDataFolder(), "Party.yml");
		partys = YamlConfiguration.loadConfiguration(partyile);
		
		if (!partyile.exists()) {
			try {
				partyile.createNewFile();
			}
			catch (IOException e) {
				 Party.log.info("Could not crate party file!");
			}
		}
	}
	
	public FileConfiguration getConfig() {
		return partys;
	}
	
	public void saveConfig() {
		try {
			partys.save(partyile);
		}
		catch (IOException e) {
	            Party.log.info("Could not save party file!");
		}
	}
	
	public PluginDescriptionFile getDescription() {
		return p.getDescription();
	}
}

