package be.zeldown.elocore.listeners;

import java.time.LocalDateTime;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import be.zeldown.elocore.EloCore;
import be.zeldown.elocore.utils.EloPlayer;

public class PlayerListener implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		EloPlayer ep = new EloPlayer(p);
		
		if(ep.isFirstConnection()) {
			ep.setElo(EloCore.getInstance().ELO_DEFAULT);
		}
		
		p.setMaxHealth(ep.getHealth());
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
		Player p = e.getEntity();
		EloPlayer ep = new EloPlayer(p);
		if(p.getKiller() != null) {
			Player killer = p.getKiller();
			EloPlayer ek = new EloPlayer(killer);
			boolean boost = false;
			if(EloCore.getInstance().getAntiKillBoostPlayer().containsKey(killer)) {
				if(EloCore.getInstance().getAntiKillBoostPlayer().get(killer).getUniqueId().equals(p.getUniqueId())) {
					LocalDateTime now = LocalDateTime.now();
					if(EloCore.getInstance().getAntiKillBoostDate().get(killer).plusDays(1).isAfter(now)) {
						ek.removeElo(100);
						killer.sendMessage("§cVous avez perdu §e100 elos §cpour raison §b§lboost élos");
						boost = true;
					}
				}
			}
			if(!boost) {
				ek.addElo(250);
				killer.sendMessage("§aVous avez gagné §e250 elos");
			}
		}
		ep.removeElo(300);
		p.sendMessage("§cVous avez perdu §e100 elos");
	}
	
}
