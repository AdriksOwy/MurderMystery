package com.murder.commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;

public class SpawnNPC implements CommandRunner {

    CommandData data;

    private void spawnMurderVillager(World world, Location location) {

        Villager villager = (Villager) world.spawnEntity(location, EntityType.VILLAGER);
        villager.setCustomName(ChatColor.YELLOW + "" + ChatColor.BOLD + "> KLIKNIJ PRZYCISK <");
        villager.setAI(false);
    }

    public boolean run() {
        if (data.sender instanceof Player) {
            Player player = (Player) data.sender;
            if (player.hasPermission("npc")) {
                spawnMurderVillager(player.getWorld(), player.getLocation());
                player.sendMessage(ChatColor.RED + "Villager was created!");
                return true;
            }
        }
        return false;
    }

    public SpawnNPC(CommandData data) {

        this.data = data;
    }
}
