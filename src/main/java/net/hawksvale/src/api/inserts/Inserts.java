package net.hawksvale.src.api.inserts;

import org.bukkit.ChatColor;

public final class Inserts {
    public static final String POSITIVE = ChatColor.DARK_GRAY
                                          + "["
                                          + ChatColor.DARK_GREEN
                                          + "+"
                                          + ChatColor.DARK_GRAY
                                          + "] "
                                          + ChatColor.GRAY;
    public static final String NEGATIVE = ChatColor.DARK_GRAY
                                          + "["
                                          + ChatColor.DARK_RED
                                          + "-"
                                          + ChatColor.DARK_GRAY
                                          + "] "
                                          + ChatColor.GRAY;
    public static final String NEUTRAL = ChatColor.DARK_GRAY
                                          + "["
                                          + ChatColor.GOLD
                                          + "*"
                                          + ChatColor.DARK_GRAY
                                          + "] "
                                          + ChatColor.GRAY;
    public static final String NEUTRAL_SMOOTH
                                          = ChatColor.DARK_GRAY
								          + "("
								          + ChatColor.GOLD
								          + "*"
								          + ChatColor.DARK_GRAY
								          + ") "
								          + ChatColor.GRAY;
    public static final String UP = ChatColor.DARK_GRAY
                                          + "["
                                          + ChatColor.YELLOW
                                          + "^"
                                          + ChatColor.DARK_GRAY
                                          + "] "
                                          + ChatColor.GRAY;
    public static final String ERROR = ChatColor.RED
                                          + "ERROR: ";
}
