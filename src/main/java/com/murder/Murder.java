package com.murder;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {
    static JavaPlugin plugin;
    public static JavaPlugin getMainPlugin() {
        return plugin;
    }
    @Override
    public void onEnable() {
        plugin = this;
        getLogger().info( ChatColor.YELLOW + " [MurderMystery] Plugin jest wlaczony! " );
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + " [MurderMystery] Plugin jest wylaczony! " );
    }
}