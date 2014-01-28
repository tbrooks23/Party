package adelie.plugins.party;

import java.util.logging.Logger;

import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

import adelie.plugins.party.Managements.PartyCommandManager;
import adelie.plugins.party.YMLS.Files;

public class Party extends JavaPlugin {
	
	public static Logger log;
	public static Plugin pl;
	
	public void onEnable() {
		//PUT THESE BAD BOYS IN
		log = getLogger();
		pl = this;
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName() + " Version: " + pdf.getVersion() + " Website: " + pdf.getWebsite());
		
		//LOAD COMMANDS/FILES/LISTENERS
		
		this.saveDefaultConfig();
		loadFile();
		loadParty();
		
		try{
			if(this.getConfig().getString("version").contains("0.0.5")) {
				log.info("We're on the same version!!");
			}
		 } catch (Exception e) {
			 log.warning("We're on the wrong version.. sad...");
		}
	}
	
	public void loadFile() {
		Files.getInstance().setup(this);
	}
	
	public void loadParty() {
		PartyCommandManager.getInstance(this).addCommands();
		getCommand("party").setExecutor(PartyCommandManager.getInstance(this));
	}

	
	public void onDisable() {
		PluginDescriptionFile pdf = this.getDescription();
		log.info(pdf.getName() + " Version: " + pdf.getVersion() + " Website: " + pdf.getWebsite());
	}

}

