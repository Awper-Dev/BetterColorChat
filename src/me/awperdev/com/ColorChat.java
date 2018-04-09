package me.awperdev.com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.awperdev.com.commands.versionCommand;
import me.awperdev.com.features.onChat;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.nio.charset.Charset;
import java.util.HashMap;

public class ColorChat extends JavaPlugin{
    private static ColorChat instance;
    private Utils utils;
    private final Gson gson = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
    private File file;
    private HashMap<String, String> OPcolors;


    @Override
    public void onEnable(){
        instance = this;
        utils = new Utils();
        registerCommands();
        try{
            loadConfig();
        }catch (Exception e){
            e.printStackTrace();
        }
        Bukkit.getServer().getPluginManager().registerEvents(new onChat(), this);
        Bukkit.getLogger().info("ColorChat enabled!");
    }

    private void loadConfig() throws Exception{
        file = new File(this.getDataFolder().getPath(), "config.json");
        if(!this.getDataFolder().exists()){
            this.getDataFolder().mkdir();
        }
            if(!file.exists()){
                file.createNewFile();
                addDefaults(file);
                HashMap<String, String> wop = new HashMap<>();
                wop.put("color","&4");
                wop.put("extra", "&l");
                OPcolors = wop;
            }else{
                loadOPColors(file);
            }

    }

    private void loadOPColors(File file)throws Exception{
        String jsonString;
        jsonString = FileUtils.readFileToString(file);
        HashMap<String, String> colors = gson.fromJson(jsonString, HashMap.class);

        Bukkit.getLogger().info("OPColors loaded! The colors are " + colors.get("color") + " and " + colors.get("extra"));
        OPcolors = colors;

    }

    private void addDefaults(File file) throws Exception{
        HashMap<String, String> def = new HashMap<>();
        def.put("color", "&4");
        def.put("extra", "&l");


        FileUtils.write(file, gson.toJson(def), Charset.defaultCharset(), false);
    }

    private void registerCommands(){
        getCommand("colorchat").setExecutor(new versionCommand());
    }

    public static ColorChat getInstance() {
        return instance;
    }

    public Utils getUtils(){
        return utils;
    }

    public Gson getGson() {
        return gson;
    }

    public HashMap<String, String> getOPcolors() {
        return OPcolors;
    }

}
