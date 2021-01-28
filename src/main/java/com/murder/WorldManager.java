package com.murder;

import jdk.tools.jlink.plugin.Plugin;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.WorldCreator;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
;

public class WorldManager {
   public JavaPlugin plugin;

    public WorldManager(){
        this.plugin = Murder.plugin;
    }

    public void createWorld(String world){
        File dataFolder = new File(plugin.getDataFolder().getPath());
        String strData = dataFolder.toString();

        String[] split = strData.toString().split(File.pathSeparator);
        String rootFolder = split[split.length - 3];

        File root = new File(rootFolder);
        File srcDir = new File(root+File.pathSeparator+"backup");

        if (!srcDir.exists()) {
            Bukkit.getLogger().warning("Backup does not exist!");
            return;
        }

        File destDir = new File(root+File.pathSeparator+world);

        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        Bukkit.getServer().createWorld(new WorldCreator(world));
    }




}
