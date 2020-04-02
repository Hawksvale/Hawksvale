package net.hawksvale.src.modulehandler;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;

import net.hawksvale.src.Main;

public abstract class ModuleWrapper implements CommandExecutor, TabExecutor, org.bukkit.event.Listener {

	public static void register(ModuleWrapper... wrappers) {
		for (ModuleWrapper wrapper : wrappers) {
			if (wrapper.getConfig() != null) {
				for (CommandName name : wrapper.getConfig().getNames()) {
					Main.getPlugin(Main.class).getCommand(name.getName()).setExecutor(wrapper);
					if (wrapper.getConfig().doesDoTabCompletion() && name.isForTabbing())
						Main.getPlugin(Main.class).getCommand(name.getName()).setTabCompleter(wrapper);
				}
				if (wrapper.getClass().isAnnotationPresent(Listener.class))
					Main.getPlugin(Main.class).getServer().getPluginManager().registerEvents(wrapper,
							Main.getPlugin(Main.class));
			}
		}
	}

	public abstract CommandConfig getConfig();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		return true;
	}

	@Override
	public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
		return null;
	}

}
