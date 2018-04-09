package me.awperdev.com.commands;

import me.awperdev.com.ColorChat;
import me.awperdev.com.Utils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class versionCommand implements CommandExecutor {

    private ColorChat plugin = ColorChat.getInstance();
    private Utils utils = plugin.getUtils();
    private String p = utils.getPrefix();
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(command.getName().equalsIgnoreCase("colorchat")){
            commandSender.sendMessage(p + ChatColor.GREEN + "enabled! Running version " + ChatColor.BLUE +  plugin.getDescription().getVersion());
        }
        return true;
    }
}
