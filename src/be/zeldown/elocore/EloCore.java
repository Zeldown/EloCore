package be.zeldown.elocore;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import be.zeldown.elocore.executors.EloExecutor;
import be.zeldown.elocore.executors.EloFactionExecutor;
import be.zeldown.elocore.listeners.PlayerListener;
import be.zeldown.elocore.managers.EloManager;
import lombok.Getter;

public class EloCore extends JavaPlugin {

	@Getter private static EloCore instance;
	
	@Getter private EloManager eloManager;
	
	public final int ELO_DEFAULT = 8000;
	
	@Getter private Map<Player, Player> antiKillBoostPlayer = new HashMap<Player, Player>();
	@Getter private Map<Player, LocalDateTime> antiKillBoostDate = new HashMap<Player, LocalDateTime>();
	
	public void onEnable() {
		/** Static fields */
		instance = this;
		
		PluginManager pm = getServer().getPluginManager();
		
		/** Listeners */
		pm.registerEvents(new PlayerListener(), this);
		
		/** Managers */
		this.eloManager = new EloManager(this);
		
		/** Commands */
		getCommand("elo").setExecutor(new EloExecutor());
		getCommand("elofaction").setExecutor(new EloFactionExecutor());
		
		/** Others */
		saveDefaultConfig();
	}

	@Override
	public void onDisable() {
		
	}
	
}
