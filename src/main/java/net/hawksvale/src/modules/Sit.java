package net.hawksvale.src.modules;

import java.util.HashMap;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.spigotmc.event.entity.EntityDismountEvent;

import net.hawksvale.src.api.inserts.Inserts;
import net.hawksvale.src.modulehandler.CommandConfig;
import net.hawksvale.src.modulehandler.Listener;
import net.hawksvale.src.modulehandler.ModuleWrapper;

@Listener
public class Sit extends ModuleWrapper {

	/**
	 * The list for all people sitting
	 */
	private static HashMap<Player, Entity> sittingList = new HashMap<Player, Entity>();

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof ConsoleCommandSender) return false;
		if (!sender.hasPermission("cepi.builder")) return false;
		Player player = (Player) sender;
		if (sittingList.containsKey(player)) {
			Entity entity = player.getVehicle();
			Location entityLoc = entity.getLocation().clone();
			player.teleport(entityLoc.add(0.0D, 1.7D, 0.0D));
			player.eject();
			sittingList.get(player).remove();
			sittingList.remove(player);
		} else if (!player.isFlying() && player.isOnGround()){
			Location location = player.getLocation();
			ArmorStand seat = (ArmorStand) location.getWorld().spawn(location.clone().subtract(0.0D, 1.7D, 0.0D), ArmorStand.class);
			seat.setGravity(false);
			seat.setVisible(false);
			seat.addPassenger(player);
			sittingList.put(player, seat);
		} else {
			player.sendMessage(Inserts.NEGATIVE + "You must be on the ground!");
		}
		return true;
	}
	
	@EventHandler
	public void onPlayerDismount(EntityDismountEvent event) {
		Entity entity = event.getEntity();
		if (entity instanceof Player) {
			Player player = (Player) event.getEntity();
			if (sittingList.containsKey(player)) {
				sittingList.get(player).remove();
				sittingList.remove(player);
			}
		}
	}

	@Override
	public CommandConfig getConfig() {
		return new CommandConfig("sit");
	}

}
