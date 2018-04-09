package me.awperdev.com;

import org.bukkit.ChatColor;

import java.util.ArrayList;

public class Utils {
    private String prefix = ChatColor.RED + "[ColorChat] ";
    private ChatColor[] colors = {ChatColor.DARK_RED, ChatColor.RED, ChatColor.GOLD, ChatColor.YELLOW, ChatColor.DARK_GREEN, ChatColor.GREEN, ChatColor.AQUA, ChatColor.DARK_AQUA, ChatColor.DARK_BLUE, ChatColor.BLUE
    ,ChatColor.LIGHT_PURPLE, ChatColor.DARK_PURPLE, ChatColor.WHITE, ChatColor.GRAY, ChatColor.DARK_GRAY, ChatColor.BLACK, ChatColor.BOLD, ChatColor.UNDERLINE, ChatColor.ITALIC, ChatColor.MAGIC, ChatColor.STRIKETHROUGH};

    private String[] perms = {"cc.darkred", "cc.red", "cc.gold", "cc.yellow", "cc.darkgreen", "cc.green", "cc.aqua", "cc.darkaqua", "cc.darkblue", "cc.blue"
    , "cc.purple", "cc.darkpurple", "cc.white", "cc.gray", "cc.darkgray", "cc.black", "cc.bold", "cc.underline", "cc.italic", "cc.magic", "cc.strikethrough"};
    public String getPrefix() {
        return prefix;
    }

    public ChatColor[] getColors() {
        return colors;
    }

    public String[] getPerms() {
        return perms;
    }
}
