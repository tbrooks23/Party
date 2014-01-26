package adelie.plugins.party.Managements;

import java.util.ArrayList;

import org.bukkit.entity.Player;

import adelie.plugins.party.YMLS.Files;

public class PartyHandlers {
	
	private ArrayList<String> members = new ArrayList<String>();
	private ArrayList<String> leaders = new ArrayList<String>();
	private Files file = Files.getInstance();
	
	
	
	
	
	//LEADERS ;3
	public ArrayList<String> getLeaders() {
		return leaders;
	}
	
	public void addLeaders(Player p) {
		leaders.add(p.getName());
		file.saveConfig();
	}
	
	public void kickLeaders(Player p) {
		leaders.remove(p.getName());
		file.saveConfig();
	}
	
	
	
	//MEMBERS
	public ArrayList<String> getMembers() {
		return members;
	}
	
	public void addMember(Player p) {
		members.add(p.getName());
		file.saveConfig();
	}
	
	public void kickMember(Player p) {
		members.remove(p.getName());
		file.saveConfig();
	}
	
	private PartyHandlers() {}
	
	public static PartyHandlers instance = new PartyHandlers();

	public static PartyHandlers getInstance() {
		return instance;
	}
	
}
