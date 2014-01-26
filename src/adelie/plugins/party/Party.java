package adelie.plugins.party;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import adelie.plugins.party.YMLS.Files;

public class Party extends JavaPlugin {
	
	public static Logger log;
	public static Plugin pl;
	
	public void onEnable() {
		log = getLogger();
		pl = this;
		//SHIT
		
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName() + " Version: " + pdf.getVersion() + " Website: " + pdf.getWebsite());
		loadFile();
		
		this.saveDefaultConfig();
		try{
			if(this.getConfig().getString("version").contains("0.0.5")) {
				log.info("We're on the same version!!");
			}
		 } catch (Exception e) {
			 log.warning("We're on the wrong version... stopping Party");
				
         	Bukkit.getServer().getPluginManager().disablePlugin(this);
		
		}
	}
	
	public void loadFile() {
		Files.getInstance().setup(this);
	}
	

	
	
	public void onDisabel() {
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName() + " Version: " + pdf.getVersion() + " Website: " + pdf.getWebsite());
	}

}

