package be.zeldown.elocore.executors;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import be.zeldown.elocore.utils.EloPlayer;

public class EloExecutor implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if(!(sender instanceof Player)) {
			if(args.length == 3) {
				if(args[0].equalsIgnoreCase("add")) {
					if(Bukkit.getPlayer(args[1]) != null) {
						try {
							int value = Integer.valueOf(args[2]);
							new EloPlayer(args[1]).addElo(value);
							sender.sendMessage("§aVous avez donné §e" + value + " elos §aà §e" + args[1]);
						} catch (Exception e) {
							sender.sendMessage("§eUsage: §b/elo add <player> <value>");
						}
					}else {
						sender.sendMessage("§cCe joueur n'existe pas");
					}
				}else if(args[0].equalsIgnoreCase("remove")) {
					if(Bukkit.getPlayer(args[1]) != null) {
						try {
							int value = Integer.valueOf(args[2]);
							new EloPlayer(args[1]).removeElo(value);
							sender.sendMessage("§cVous avez retiré §e" + value + " elos §cà §e" + args[1]);
						} catch (Exception e) {
							sender.sendMessage("§eUsage: §b/elo remove <player> <value>");
						}
					}else {
						sender.sendMessage("§cCe joueur n'existe pas");
					}
				}else if(args[0].equalsIgnoreCase("set")) {
					if(Bukkit.getPlayer(args[1]) != null) {
						try {
							int value = Integer.valueOf(args[2]);
							new EloPlayer(args[1]).setElo(value);
							sender.sendMessage("§3Vous avez définis §e" + value + " elos §3à §e" + args[1]);
						} catch (Exception e) {
							sender.sendMessage("§eUsage: §b/elo set <player> <value>");
						}
					}else {
						sender.sendMessage("§cCe joueur n'existe pas");
					}
				}
			}else {
				sender.sendMessage("§cVous devez être un joueur");
			}
			return true;
		}
		Player p = (Player) sender;
		EloPlayer ep = new EloPlayer(p);
		if(args.length == 0) {
			p.sendMessage("§aVous avez §e" + ep.getElo() + " elos");
		}else if(args.length == 1) {
			if(Bukkit.getPlayer(args[0]) != null) {
				p.sendMessage("§aLe joueur §e" + args[0] + " §aa §e" + new EloPlayer(args[0]).getElo() + " elos");
			}else {
				p.sendMessage("§cCe joueur n'existe pas");
			}
		}else if(args.length == 3 && p.hasPermission("cmd.elo.edit")) {
			if(args[0].equalsIgnoreCase("add")) {
				if(Bukkit.getPlayer(args[1]) != null) {
					try {
						int value = Integer.valueOf(args[2]);
						new EloPlayer(args[1]).addElo(value);
						p.sendMessage("§aVous avez donné §e" + value + " elos §aà §e" + args[1]);
					} catch (Exception e) {
						p.sendMessage("§eUsage: §b/elo add <player> <value>");
					}
				}else {
					p.sendMessage("§cCe joueur n'existe pas");
				}
			}else if(args[0].equalsIgnoreCase("remove")) {
				if(Bukkit.getPlayer(args[1]) != null) {
					try {
						int value = Integer.valueOf(args[2]);
						new EloPlayer(args[1]).removeElo(value);
						p.sendMessage("§cVous avez retiré §e" + value + " elos §cà §e" + args[1]);
					} catch (Exception e) {
						p.sendMessage("§eUsage: §b/elo remove <player> <value>");
					}
				}else {
					p.sendMessage("§cCe joueur n'existe pas");
				}
			}else if(args[0].equalsIgnoreCase("set")) {
				if(Bukkit.getPlayer(args[1]) != null) {
					try {
						int value = Integer.valueOf(args[2]);
						new EloPlayer(args[1]).setElo(value);
						p.sendMessage("§3Vous avez définis §e" + value + " elos §3à §e" + args[1]);
					} catch (Exception e) {
						p.sendMessage("§eUsage: §b/elo set <player> <value>");
					}
				}else {
					p.sendMessage("§cCe joueur n'existe pas");
				}
			}
		}
		return true;
	}

}
