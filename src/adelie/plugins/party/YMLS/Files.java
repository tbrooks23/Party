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
	File paryile;
	
	public void setup(Plugin p) {
		this.p = p;
		
		if (!p.getDataFolder().exists()) p.getDataFolder().mkdir();
		
		paryile = new File(p.getDataFolder(), "party.yml");
		partys = YamlConfiguration.loadConfiguration(paryile);
		
		if (!paryile.exists()) {
			try {
				paryile.createNewFile();
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
			partys.save(paryile);
		}
		catch (IOException e) {
	            Party.log.info("Could not save party file!");
		}
	}
	
	public PluginDescriptionFile getDescription() {
		return p.getDescription();
	}
}

