package net.hawksvale.src;

import org.bukkit.plugin.java.JavaPlugin;

import net.hawksvale.src.modulehandler.ModuleWrapper;
import net.hawksvale.src.modules.AddDefaultRanks;
import net.hawksvale.src.modules.FormattedChat;
import net.hawksvale.src.modules.Referrer;
import net.hawksvale.src.modules.Respawn;
import net.hawksvale.src.modules.Sit;

public class Main extends JavaPlugin {

	public void onEnable() {
		ModuleWrapper.register(new Respawn(),
				new AddDefaultRanks(),
				new Referrer(),
				new FormattedChat(),
				new Sit());
	}
	
}
