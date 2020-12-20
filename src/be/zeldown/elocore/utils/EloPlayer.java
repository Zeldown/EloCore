package be.zeldown.elocore.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import be.zeldown.elocore.EloCore;
import lombok.Getter;

/**
 * @author Zeldown
 *
 */
public class EloPlayer {

	@Getter private Player player;
	

	/**
	 * @param player
	 * @apiNote Retourne un EloPlayer (Object contenant les elos d'un joueur)
	 */
	public EloPlayer(Player player) {
		this.player = player;
	}

	/**
	 * @param playerName
	 * @apiNote Retourne un EloPlayer (Object contenant les elos d'un joueur)
	 */
	public EloPlayer(String name) {
		this.player = Bukkit.getPlayer(name);
	}

	/**
	 * @return elos du joueur
	 * @apiNote Retourne le nombre d'élo du joueur
	 */
	public int getElo() {
		return EloCore.getInstance().getEloManager().getPlayerElo(this.player);
	}

	
	/**
	 * @param elo
	 * @return L'object EloPlayer
	 * @apiNote Définis le nombre d'elo du joueur
	 */
	public EloPlayer setElo(int elo) {
		EloCore.getInstance().getEloManager().setPlayerElo(this.player, elo);
		return this;
	}

	
	/**
	 * @param Nombre d'élo à ajouter
	 * @return L'object EloPlayer
	 * @apiNote Ajout "value" elo au joueur
	 */
	public EloPlayer addElo(int value) {
		EloCore.getInstance().getEloManager().addPlayerElo(this.player, value);
		return this;
	}

	
	/**
	 * @param Nombre d'élo à retirer
	 * @return L'object EloPlayer
	 * @apiNote Retire "value" elo au joueur
	 */
	
	public EloPlayer removeElo(int value) {
		EloCore.getInstance().getEloManager().removePlayerElo(this.player, value);
		return this;
	}
	
	/**
	 * @return vie du joueur en fonction de ses elos
	 */
	public float getHealth() {
		return EloCore.getInstance().getEloManager().getHealthFromElo(this.player);
	}
	
	
	/**
	 * @return si le joueur est déjà enregistrer
	 */
	public boolean isFirstConnection() {
		return EloCore.getInstance().getConfig().get("elo.players." + this.player.getUniqueId()) == null;
	}
	
}
