package com.murder.events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class MurderNPCEvent implements Listener {

    @EventHandler
    public void on(PlayerInteractEntityEvent event) {

        Player player = event.getPlayer();
        if (event.getRightClicked() instanceof Villager) {
            Villager villager = (Villager) event.getRightClicked();
            if (villager.getCustomName().equalsIgnoreCase(ChatColor.YELLOW + "" + ChatColor.BOLD + "> KLIKNIJ PRZYCISK <")) {
                player.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Trwa laczenie z serwerem...");
            }
        }
    }
}
