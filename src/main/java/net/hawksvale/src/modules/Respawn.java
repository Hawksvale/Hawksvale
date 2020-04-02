package net.hawksvale.src.modules;

import java.util.concurrent.ThreadLocalRandom;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerRespawnEvent;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.exceptions.TownyException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;

import net.hawksvale.src.modulehandler.CommandConfig;
import net.hawksvale.src.modulehandler.ModuleWrapper;

public class Respawn extends ModuleWrapper {

	@EventHandler
	public void OnRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Resident resident = null;
		try {
			resident = TownyAPI.getInstance().getDataSource().getResident(player.getName());
		} catch (NotRegisteredException e) {
			e.printStackTrace();
		}
		if (player.getBedLocation() != null) {
			event.setRespawnLocation(player.getBedLocation());
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			String command = "broadcast we're here";
			Bukkit.dispatchCommand((CommandSender) console, command);
		} else if (resident.hasTown()) {
			Town town = null;
			Location townspawn = null;
			try {
				town = resident.getTown();
			} catch (NotRegisteredException e) {
				e.printStackTrace();
			}
			try {
				townspawn = town.getSpawn();
			} catch (TownyException e) {
				e.printStackTrace();
			}
			event.setRespawnLocation(townspawn);
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			String command = "broadcast we're here 2";
			Bukkit.dispatchCommand((CommandSender) console, command);
		} else {
			ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
			String command = "broadcast we're here 3";
			Bukkit.dispatchCommand((CommandSender) console, command);
			int min = -4000;
			int max = 4000;
			int X = ThreadLocalRandom.current().nextInt(min, max + 1);
			int Z = ThreadLocalRandom.current().nextInt(min, max + 1);
			Block y = Bukkit.getWorld("world").getHighestBlockAt(X, Z);
			int YLoc = y.getY() + 1;
			Location loc = new Location(Bukkit.getWorld("world"), X, YLoc, Z);
			event.setRespawnLocation(loc);
		}
	}

	@Override
	public CommandConfig getConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		// TODO Auto-generated method stub
		return false;
	}
}
