package net.hawksvale.src.modules;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerJoinEvent;

import net.hawksvale.src.modulehandler.CommandConfig;
import net.hawksvale.src.modulehandler.ModuleWrapper;

public class AddDefaultRanks extends ModuleWrapper {

	@EventHandler
	public void onJoin(PlayerJoinEvent event) {
		Player player = event.getPlayer();
		String name = player.getName();
		if (!player.hasPlayedBefore()) {
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			String command = "lp user " + name + " parent add wanderer";
			String command2 = "lp user " + name + " parent add referred";
			String command3 = "lp user " + name + " parent remove default";
			Bukkit.dispatchCommand((CommandSender) console, command);
			Bukkit.dispatchCommand((CommandSender) console, command2);
			Bukkit.dispatchCommand((CommandSender) console, command3);
		}
	}

	@Override
	public CommandConfig getConfig() {
		// TODO Auto-generated method stub
		return null;
	}
}
