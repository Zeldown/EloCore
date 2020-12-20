package be.zeldown.elocore.managers;

import org.bukkit.entity.Player;

import com.massivecraft.factions.Faction;

import be.zeldown.elocore.EloCore;

public class EloManager {

	private EloCore main;
	
	public EloManager(EloCore main) {
		this.main = main;
	}
	
	/** Player Manager */

	public int getPlayerElo(Player player) {
		int elo = main.ELO_DEFAULT;
		if(main.getConfig().get("elo.players." + player.getUniqueId()) != null) {
			elo = main.getConfig().getInt("elo.players." + player.getUniqueId());
		}
		return elo;
	}
	
	public void setPlayerElo(Player player, int elo) {
		main.getConfig().set("elo.players." + player.getUniqueId(), elo);
		main.saveConfig();
	}
	
	public void addPlayerElo(Player player, int value) {
		int elo = getPlayerElo(player);
		elo+=value;
		setPlayerElo(player, elo);
	}
	
	public void removePlayerElo(Player player, int value) {
		int elo = getPlayerElo(player);
		elo-=value;
		setPlayerElo(player, elo);
	}
	
	public float getHealthFromElo(Player player) {
		int elo = getPlayerElo(player);
		if(elo <= -7000) {
			return 6f*2f;
		}else if(elo >= 16000 && elo < 32000) {
			return 7.5f*2f;
		}else if(elo >= 32000 && elo < 64000) {
			return 8f*2f;
		}else if(elo >= 64000 && elo < 128000) {
			return 8.5f*2f;
		}else if(elo >= 128000 && elo < 256000) {
			return 9f*2f;
		}else if(elo >= 256000 && elo < 512000) {
			return 9.5f*2f;
		}else if(elo >= 512000) {
			return 10f*2f;
		}
		return 7f*2f;
	}
	
	/** Faction Manager */

	public int getFactionElo(Faction faction) {
		int elo = 0;
		if(main.getConfig().get("elo.factions." + faction.getId()) != null) {
			elo = main.getConfig().getInt("elo.factions." + faction.getId());
		}
		return elo;
	}
	
	public void setFactionElo(Faction faction, int elo) {
		main.getConfig().set("elo.factions." + faction.getId(), elo);
		main.saveConfig();
	}
	
	public void addFactionElo(Faction faction, int value) {
		int elo = getFactionElo(faction);
		elo+=value;
		setFactionElo(faction, elo);
	}
	
	public void removeFactionElo(Faction faction, int value) {
		int elo = getFactionElo(faction);
		elo-=value;
		setFactionElo(faction, elo);
	}
	
}
