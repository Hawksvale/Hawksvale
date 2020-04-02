package net.hawksvale.src.modules;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import net.hawksvale.src.api.inserts.Inserts;
import net.hawksvale.src.modulehandler.CommandConfig;
import net.hawksvale.src.modulehandler.ModuleWrapper;

public class Referrer extends ModuleWrapper {

	/**
	 * Allows new players to point to who they referred
	 */
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (!(sender instanceof Player))
			return true;
		Player player = (Player) sender;
		String senderName = player.getName();
		if (!sender.hasPermission("is.ref")) {
			player.sendMessage(Inserts.NEGATIVE + "You have already used this command.");
			return true;
		} else {
			if (args.length > 0) {
				String referrerString = args[0];
				@SuppressWarnings("deprecation")
				Boolean hasPlayedBefore = Bukkit.getOfflinePlayer(referrerString).hasPlayedBefore();
				if (hasPlayedBefore && referrerString != player.getName()) {
					ConsoleCommandSender consoleCommandSender2 = Bukkit.getServer().getConsoleSender();
					String str2 = "eco give " + referrerString + " 10000";
					String command2 = "lp user " + senderName + " parent remove referred";
					Bukkit.dispatchCommand((CommandSender) consoleCommandSender2, str2);
					Bukkit.dispatchCommand((CommandSender) consoleCommandSender2, command2);
					player.sendMessage(Inserts.POSITIVE + "Referred " + referrerString + "!");
					return true;
				} else if (referrerString == player.getName()) {
					player.sendMessage(Inserts.NEGATIVE + "You can not refer yourself!");
					return true;
				} else {
					player.sendMessage(Inserts.POSITIVE + "That player has never played on this server!");
					return true;
				}
			}
			player.sendMessage(Inserts.NEGATIVE + "You must include the name of the person that referred you.");
			return true;
		}
	}

	@Override
	public CommandConfig getConfig() {
		return new CommandConfig("ref", "referral");
	}
}
