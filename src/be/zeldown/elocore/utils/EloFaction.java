package be.zeldown.elocore.utils;

import com.massivecraft.factions.Faction;
import com.massivecraft.factions.Factions;

import be.zeldown.elocore.EloCore;
import lombok.Getter;

/**
 * @author Zeldown
 *
 */
public class EloFaction {

	@Getter private Faction faction;
	
	/**
	 * @param faction
	 * @apiNote Retourne un EloFaction (Object contenant les elos d'une faction)
	 */
	public EloFaction(Faction faction) {
		this.faction = faction;
	}

	/**
	 * @param factionName
	 * @apiNote Retourne un EloFaction (Object contenant les elos d'une faction)
	 */
	public EloFaction(String name) {
		this.faction = Factions.getInstance().getByTag(name);
	}
	
	/**
	 * @return elos de la faction
	 * @apiNote Retourne le nombre d'élo de la faction
	 */
	public int getElo() {
		return EloCore.getInstance().getEloManager().getFactionElo(this.faction);
	}
	
	/**
	 * @param elo
	 * @return L'object EloFaction
	 * @apiNote Définis le nombre d'elo de la faction
	 */
	public EloFaction setElo(int elo) {
		EloCore.getInstance().getEloManager().setFactionElo(this.faction, elo);
		return this;
	}
	
	/**
	 * @param Nombre d'élo à ajouter
	 * @return L'object EloFaction
	 * @apiNote Ajout "value" elo à la faction
	 */
	public EloFaction addElo(int value) {
		EloCore.getInstance().getEloManager().addFactionElo(this.faction, value);
		return this;
	}

	
	/**
	 * @param Nombre d'élo à retirer
	 * @return L'object EloFaction
	 * @apiNote Retire "value" elo à la faction
	 */
	public EloFaction removeElo(int value) {
		EloCore.getInstance().getEloManager().removeFactionElo(this.faction, value);
		return this;
	}
	
}
