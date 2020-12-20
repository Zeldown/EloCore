package be.zeldown.elocore.executors;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.massivecraft.factions.FPlayer;
import com.massivecraft.factions.FPlayers;
import com.massivecraft.factions.Factions;

import be.zeldown.elocore.utils.EloFaction;
import be.zeldown.elocore.utils.EloPlayer;

public class EloFactionExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			if(args.length == 3) {
				
			}else {
				sender.sendMessage("§cVous devez être un joueur");
			}
			return true;
		}
		Player p = (Player) sender;
		FPlayer fp = FPlayers.getInstance().getByPlayer(p);
		if(!fp.hasFaction()) {
			p.sendMessage("§cVous n'avez pas de faction.");
			return true;
		}
		EloFaction ef = new EloFaction(fp.getFaction());
		if(args.length == 0) {
			p.sendMessage("§aVotre faction à §e" + ef.getElo() + " elos");
		}else if(args.length == 1) {
			if(Factions.getInstance().getByTag(args[0]) != null) {
				p.sendMessage("§aLa faction §e" + args[0] + " §aa §e" + new EloFaction(args[0]).getElo() + " elos");
			}else {
				p.sendMessage("§cCette faction n'existe pas");
			}
		}else if(args.length == 3 && p.hasPermission("cmd.elofaction.edit")) {
			if(args[0].equalsIgnoreCase("add")) {
				if(Factions.getInstance().getByTag(args[1]) != null) {
					try {
						int value = Integer.valueOf(args[2]);
						new EloFaction(args[1]).addElo(value);
						p.sendMessage("§aVous avez donné §e" + value + " elos §aà §e" + args[1]);
					} catch (Exception e) {
						p.sendMessage("§eUsage: §b/elo add <faction> <value>");
					}
				}else {
					p.sendMessage("§cCette faction n'existe pas");
				}
			}else if(args[0].equalsIgnoreCase("remove")) {
				if(Factions.getInstance().getByTag(args[1]) != null) {
					try {
						int value = Integer.valueOf(args[2]);
						new EloFaction(args[1]).removeElo(value);
						p.sendMessage("§cVous avez retiré §e" + value + " elos §cà §e" + args[1]);
					} catch (Exception e) {
						p.sendMessage("§eUsage: §b/elo remove <faction> <value>");
					}
				}else {
					p.sendMessage("§cCette faction n'existe pas");
				}
			}else if(args[0].equalsIgnoreCase("set")) {
				if(Factions.getInstance().getByTag(args[1]) != null) {
					try {
						int value = Integer.valueOf(args[2]);
						new EloFaction(args[1]).setElo(value);
						p.sendMessage("§3Vous avez définis §e" + value + " elos §3à §e" + args[1]);
					} catch (Exception e) {
						p.sendMessage("§eUsage: §b/elo set <faction> <value>");
					}
				}else {
					p.sendMessage("§cCette faction n'existe pas");
				}
			}
		}
		return true;
	}

}
