package com.murder.world;

import com.murder.Murder;
import org.apache.commons.io.FileUtils;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public class WorldRemover {

    private JavaPlugin plugin;
    private World world;

    public void deleteWorld() {
        Bukkit.getServer().unloadWorld(world, true);
        File dir = new File(world.getWorldFolder().getPath());

        try {
            FileUtils.deleteDirectory(dir);
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public WorldRemover(String worldName) {

        this.world = Bukkit.getWorld(worldName);
        this.plugin = Murder.getMainPlugin();
    }

    public WorldRemover(World world) {

        this.world = world;
        this.plugin = Murder.getMainPlugin();
    }
}
