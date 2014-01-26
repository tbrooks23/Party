package adelie.plugins.party.Commands;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import adelie.plugins.party.Managements.PartyCommand;

public class Create implements PartyCommand {

	@Override
	public void onCommand(Player p, String[] args) {
			p.sendMessage(ChatColor.GRAY + "You have started a party");
			p.sendMessage(ChatColor.GREEN + "Start inviting people to your party /party invite");

	}


	public String name() {
		return "create";
	}


	public String alias() {
		return "open";
	}

}
