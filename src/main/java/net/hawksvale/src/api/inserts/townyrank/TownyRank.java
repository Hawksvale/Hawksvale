package net.hawksvale.src.api.inserts.townyrank;

import net.md_5.bungee.api.ChatColor;

public enum TownyRank {

	KING(ChatColor.RED, "King"),
	MAYOR(ChatColor.GOLD, "Mayor"),
	RESIDENT(ChatColor.GREEN, "Resident"),
	WANDERER(ChatColor.GRAY, "Wanderer");
	
	String name;
	ChatColor color;
	
	private TownyRank(ChatColor color, String name) {
		this.color = color;
		this.name = name;
	}
	
	public ChatColor getColor() {
		return this.color;
	}
	
	public String getName() {
		return this.name;
	}
	
}
