package net.hawksvale.src.api.inserts;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.TextComponent;

public final class InsertComponents {

	public static final TextComponent generate(ChatColor bracketColor, String symbol, ChatColor symbolColor, ChatColor normalColor) {
		TextComponent openBracket = new TextComponent();
		openBracket.setColor(bracketColor);
		openBracket.setText("[");
		
		TextComponent symbolComponent = new TextComponent();
		symbolComponent.setColor(symbolColor);
		symbolComponent.setText(symbol);
		openBracket.addExtra(symbolComponent);
		
		TextComponent closedBracket = new TextComponent();
		closedBracket.setColor(bracketColor);
		closedBracket.setText("] ");
		openBracket.addExtra(closedBracket);
		
		TextComponent normalText = new TextComponent();
		normalText.setColor(normalColor);
		openBracket.addExtra(normalText);
		
		return openBracket;
	}
	
	public static final TextComponent POSITIVE = InsertComponents.generate(ChatColor.DARK_GRAY, "+", ChatColor.DARK_GREEN, ChatColor.GRAY);
	
	public static final TextComponent NEGATIVE = InsertComponents.generate(ChatColor.DARK_GRAY, "-", ChatColor.DARK_RED, ChatColor.GRAY);
	
	public static final TextComponent NEUTRAL = InsertComponents.generate(ChatColor.DARK_GRAY, "*", ChatColor.GOLD, ChatColor.GRAY);
	
}
