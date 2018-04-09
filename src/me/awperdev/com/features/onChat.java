package me.awperdev.com.features;

import me.awperdev.com.ColorChat;
import me.awperdev.com.Utils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class onChat implements Listener {
    private ColorChat plugin = ColorChat.getInstance();
    private Utils utils = plugin.getUtils();
    private ChatColor[] colors = utils.getColors();
    private String[] perms = utils.getPerms();
    private HashMap<String, String> OPColors = plugin.getOPcolors();

    private ArrayList<ChatColor> colorArrayList = new ArrayList<>(Arrays.asList(colors));
    private ArrayList<String> permsArrayList = new ArrayList<>(Arrays.asList(perms));

    @EventHandler
    public void onPChatEvent(AsyncPlayerChatEvent event) {

        Player p = event.getPlayer();

        if(p.hasPermission("*") || p.isOp()){
            event.setMessage(ChatColor.translateAlternateColorCodes('&', OPColors.get("color") + "" + ChatColor.translateAlternateColorCodes('&', OPColors.get("extra")) + event.getMessage()));
        }else{
            ChatColor[] colors = neededColors(p);
            event.setMessage(colors[0].toString() + "" + colors[1].toString() + event.getMessage());
        }
    }


    private ChatColor[] neededColors(Player player) {

        ChatColor color1 = ChatColor.WHITE;
        ChatColor mod = null;

        for (String perm : permsArrayList) {
            if (player.hasPermission(perm)) {
                int index = permsArrayList.indexOf(perm);
                if(index >15){
                    mod = colorArrayList.get(index);
                }else{
                    color1 = colorArrayList.get(index);
                }


            }
        }
        if(mod == null){
            mod = color1;
        }
        ChatColor[] returned = {color1, mod};
        return returned;
    }
}
