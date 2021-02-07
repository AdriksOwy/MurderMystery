package com.murder.world;

import com.murder.Murder;
import com.murder.runnables.WaitingRoom;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class WorldCreator {

    private JavaPlugin plugin;
    private String worldName;

    public World createWorld(String world) throws IOException {
        File dataFolder = new File(plugin.getDataFolder().getPath());
        String strData = dataFolder.toString();

        String[] split = strData.split(File.pathSeparator);
        String rootFolder = split[split.length - 3];

        File root = new File(rootFolder);
        File srcDir = new File(root+File.pathSeparator+"backup");

        if (!srcDir.exists()) {
            Bukkit.getLogger().warning(ChatColor.RED +"Backup does not exist!");
            throw new IOException("Directory does not exist.");
        }

        File destDir = new File(root+File.pathSeparator+world);

        try {
            FileUtils.copyDirectory(srcDir, destDir);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        org.bukkit.WorldCreator creator = new org.bukkit.WorldCreator(world);
        return Bukkit.getServer().createWorld(creator);
        // insert here waitngroom:
        //WaitingRoom waitingRoom = new WaitingRoom(world, 1).runTaskAsynchronously(Murder.getMainPlugin());
        //waitingRoom.startUpdates(gameID);
    }

    public WorldCreator(String worldName) {

        this.worldName = worldName;
        this.plugin = Murder.getMainPlugin();
    }
}
