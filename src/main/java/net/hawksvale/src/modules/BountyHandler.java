package net.hawksvale.src.modules;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import net.Indyuce.bountyhunters.api.event.BountyChangeEvent;
import net.Indyuce.bountyhunters.api.event.BountyClaimEvent;
import net.Indyuce.bountyhunters.api.event.BountyCreateEvent;
import net.Indyuce.bountyhunters.api.event.BountyExpireEvent;
import net.hawksvale.src.modulehandler.Listener;
import net.hawksvale.src.modulehandler.ModuleWrapper;

@Listener
public class BountyHandler extends ModuleWrapper {
	
	@SuppressWarnings("unused")
	private static void setBounty(Player player, Double bounty) {
		//TODO make function
	}
	
	@EventHandler
	public void onBountyCreate(BountyCreateEvent event) {
		
	}
	
	@EventHandler
	public void onBountyChange(BountyChangeEvent event) {
		
	}
	
	@EventHandler
	public void onBountyExpire(BountyExpireEvent event) {
		
	}
	
	@EventHandler
	public void onBountyClaim(BountyClaimEvent event) {
		
	}
	
}
