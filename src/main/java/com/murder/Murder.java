package com.murder;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info( ChatColor.YELLOW + " [MurderMystery] Plugin jest wlaczony! " );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().info(ChatColor.RED + " [MurderMystery] Plugin jest wylaczony! " );
    }
}
