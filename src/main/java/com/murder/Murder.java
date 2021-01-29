package com.murder;

import com.murder.events.MurderNPCEvent;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {

    static JavaPlugin plugin;
    public static JavaPlugin getMainPlugin() {

        return plugin;
    }

    @Override
    public void onEnable() {

        plugin = this;
        getServer().getPluginManager().registerEvents(new MurderNPCEvent(), this);
        getLogger().info( ChatColor.AQUA + " [MurderMystery] Plugin is enable! " );
    }

    @Override
    public void onDisable() {

        getLogger().info(ChatColor.RED + " [MurderMystery] Plugin is disable! " );
    }
}