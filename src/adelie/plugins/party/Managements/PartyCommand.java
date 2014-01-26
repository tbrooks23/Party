package adelie.plugins.party.Managements;

import org.bukkit.entity.Player;

import adelie.plugins.party.YMLS.Files;

public interface PartyCommand {
	
	Files f = Files.getInstance();
	PartyHandlers ph = PartyHandlers.getInstance();
	
	
	public void onCommand(Player p, String[] args);

	public String name();
	
	public String alias();



}
