package com.murder;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Murder extends JavaPlugin {

    static JavaPlugin plugin;
    public static JavaPlugin getMainPlugin() {

        return plugin;
    }

    @Override
    public void onEnable() {

        plugin = this;
        getLogger().info( ChatColor.AQUA + " [MurderMystery] Plugin is enable! " );
    }

    @Override
    public void onDisable() {

        getLogger().info(ChatColor.RED + " [MurderMystery] Plugin is disable! " );
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("SetVillager")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if (player.hasPermission("npc")) {
                    Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                    villager.setCustomName("Murder");
                    player.sendMessage(ChatColor.RED + "Villager was created!");
                    return true;
                }
            }
        }
        return false;
    }
    @EventHandler
    public void on (PlayerInteractEntityEvent event) {
        Player player = event.getPlayer ();
        if (event.getRightClicked () instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked ();
            if (villager.getCustomName (). equalsIgnoreCase ("Murder")) {
                player.sendMessage("O kurwa dziala!");
            }
        }
    }
}