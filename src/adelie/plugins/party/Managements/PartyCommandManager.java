package adelie.plugins.party.Managements;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.Vector;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import adelie.plugins.party.Commands.Create;

public class PartyCommandManager implements CommandExecutor {
	
	private PartyCommandManager() {}
	
	static PartyCommandManager instance = new PartyCommandManager();
	
	public static PartyCommandManager getInstance(Plugin p) {
		return instance;
	}

	
	TreeMap<String, PartyCommand> commands = new TreeMap<String, PartyCommand>();
	
	public void addCommands() {
		commands.put("create", new Create());
		
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.GREEN + "[Party]" + ChatColor.RED + " You cannot use party via console");
			return true;
		}
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("party")) {
			if(args.length == 0) {
				p.sendMessage(ChatColor.RED + "==== " + ChatColor.GRAY + "[" + ChatColor.GREEN + "Party" + ChatColor.GRAY + "]" + ChatColor.RED + " ====");
				p.sendMessage(ChatColor.GREEN + "/" + cmd.getName() + " create" + ChatColor.GRAY + " - Create a party");
				return true;
			}
			else {
				String sub = args[0];
		        Vector < String > l = new Vector < String > ();
		        l.addAll(Arrays.asList(args));
		        l.remove(0);
		        args = l.toArray(new String[0]);
		        PartyCommand c = getCommand(sub);
		        if(c == null) {
		        	p.sendMessage(ChatColor.RED + "That party command does not exist!");
		        	return true;
		        }
		        try {
		        	c.onCommand(p, args);
		        }
		        catch (Exception e) {
		        	e.printStackTrace();
		        	p.sendMessage(ChatColor.AQUA + "An error has occured while trying to use " + e.getMessage());
		        }
			}
		}
		return false;
	}
	
	private PartyCommand getCommand(String key) {
		for (PartyCommand tc : commands.values()) {
			if (tc.name().equalsIgnoreCase(key)) {
				return tc;
			}
			if (tc.alias() != null && tc.alias().equalsIgnoreCase(key)) {
				return tc;
			}
		}
		return null;
	}
}
