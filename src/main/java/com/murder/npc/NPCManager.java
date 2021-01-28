package com.murder.npc;

import org.bukkit.Color;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

import java.util.UUID;

public class NPCManager {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("SetVillager")) {
            if (sender instanceof Player) {
                Player player = (Player) sender;
                if(player.hasPermission("npc")) {
                    Villager villager = (Villager) player.getWorld().spawnEntity(player.getLocation(), EntityType.VILLAGER);
                    villager.setCustomName("Murder Mystery");
                    player.sendMessage(Color.RED + "Villager was created!");
                }
            }
        }
        return false;
    }
}
