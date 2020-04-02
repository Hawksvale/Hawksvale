package net.hawksvale.src.modules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;

import net.hawksvale.src.modulehandler.CommandConfig;
import net.hawksvale.src.modulehandler.ModuleWrapper;

public class TownyCheck extends ModuleWrapper {

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("townycheck")) {
			if (!(sender instanceof Player)) {
				sender.sendMessage("Only players may execute this command");
				return true;
			}
			Player player = (Player) sender;
			Resident resident = null;
			String name = player.getName();
			try {
				resident = TownyAPI.getInstance().getDataSource().getResident(name);
			} catch (NotRegisteredException e) {
				ConsoleCommandSender consoleCommandSender = Bukkit.getServer().getConsoleSender();
				String command = "broadcast the plugin maker sucks";
				Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command);
				e.printStackTrace();
				return false;
			}
			if (resident.hasTown()) {
				ConsoleCommandSender consoleCommandSender = Bukkit.getServer().getConsoleSender();
				if (resident.isMayor()) {
					if (resident.isKing() && !player.hasPermission("is.president")) {
						String command = "lp user " + name + " parent add president";
						Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command);
						if (player.hasPermission("is.mayor")) {
							String command1 = "lp user " + name + " parent remove mayor";
							Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command1);
							return true;
						}
						if (player.hasPermission("is.resident")) {
							String command1 = "lp user " + name + " parent remove resident";
							Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command1);
							return true;
						}
						return true;
					}
					if (!resident.isKing() && player.hasPermission("is.president")) {
						String command = "lp user " + name + " parent remove president";
						Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command);
						String command1 = "lp user " + name + " parent add mayor";
						Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command1);
						return true;
					}
					if (!player.hasPermission("is.mayor") && !resident.isKing()) {
						String command = "lp user " + name + " parent add mayor";
						Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command);
						if (player.hasPermission("is.resident")) {
							String str = "lp user " + name + " parent remove resident";
							Bukkit.dispatchCommand((CommandSender) consoleCommandSender, str);
							return true;
						}
						String command1 = "lp user " + name + " parent remove wanderer";
						Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command1);
						return true;
					}
					return false;
				}
				if (!player.hasPermission("is.resident")) {
					String command = "lp user " + name + " parent add resident";
					Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command);
					String command1 = "lp user " + name + " parent remove wanderer";
					Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command1);
					if (player.hasPermission("is.mayor")) {
						String command2 = "lp user " + name + " parent remove mayor";
						Bukkit.dispatchCommand((CommandSender) consoleCommandSender, command2);
						return true;
					}
					return true;
				}
				return false;
			}
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			if (player.hasPermission("is.resident")) {
				String command = "lp user " + name + " parent remove resident";
				Bukkit.dispatchCommand((CommandSender) console, command);
				String command1 = "lp user " + name + " parent add wanderer";
				Bukkit.dispatchCommand((CommandSender) console, command1);
				return true;
			}
			if (player.hasPermission("is.mayor")) {
				String command = "lp user " + name + " parent remove mayor";
				Bukkit.dispatchCommand((CommandSender) console, command);
				String command1 = "lp user " + name + " parent add wanderer";
				Bukkit.dispatchCommand((CommandSender) console, command1);
				return true;
			}
			if (player.hasPermission("is.president")) {
				String command = "lp user " + name + " parent remove president";
				Bukkit.dispatchCommand((CommandSender) console, command);
				String command1 = "lp user " + name + " parent add wanderer";
				Bukkit.dispatchCommand((CommandSender) console, command1);
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public CommandConfig getConfig() {
		return new CommandConfig("townycheck");
	}
}
