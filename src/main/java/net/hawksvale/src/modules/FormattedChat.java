package net.hawksvale.src.modules;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;

import me.lucko.luckperms.LuckPerms;
import me.lucko.luckperms.api.Contexts;
import me.lucko.luckperms.api.LuckPermsApi;
import me.lucko.luckperms.api.User;
import net.hawksvale.src.api.inserts.townyrank.GetTownyRank;
import net.hawksvale.src.api.inserts.townyrank.TownyRank;
import net.hawksvale.src.modulehandler.Listener;
import net.hawksvale.src.modulehandler.ModuleWrapper;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.TextComponent;

@Listener
public class FormattedChat extends ModuleWrapper {

	static LuckPermsApi lpAPI = LuckPerms.getApi();

	public static String getPrefix(Player player) {
		User user = lpAPI.getUser(player.getUniqueId());
		Contexts userCtx = lpAPI.getContextForUser(user)
				.orElseThrow(() -> new IllegalStateException("Could not get LuckPerms context for player " + player));
		return user.getCachedData().getMetaData(userCtx).getPrefix();
	}

	@EventHandler(priority = EventPriority.LOWEST)
	public void onAsyncPlayerChatEvent(AsyncPlayerChatEvent event) throws NotRegisteredException {

		System.out.println("e");

		Player player = event.getPlayer();
		Resident resident = TownyAPI.getInstance().getDataSource().getResident(player.getName());
		TownyRank rank = GetTownyRank.getTownyRank(player);

		event.setCancelled(true);

		BaseComponent[] components;
		if (resident.hasTown()) {
			components = TextComponent.fromLegacyText(ChatColor.translateAlternateColorCodes('&', getPrefix(player))
					+ ChatColor.RESET + player.getDisplayName() + ChatColor.DARK_GRAY + " [" + rank.getColor()
					+ resident.getTown().getName() + ChatColor.DARK_GRAY + "]" + ChatColor.GRAY + " // "
					+ ChatColor.RESET + event.getMessage());
		} else {
			components = TextComponent
					.fromLegacyText(ChatColor.translateAlternateColorCodes('&', getPrefix(player)) + ChatColor.RESET
							+ player.getDisplayName() + ChatColor.GRAY + " // " + ChatColor.RESET + event.getMessage());
		}
		for (Player loopPlayer : Bukkit.getOnlinePlayers()) {
			loopPlayer.spigot().sendMessage(components);
		}

	}

}
