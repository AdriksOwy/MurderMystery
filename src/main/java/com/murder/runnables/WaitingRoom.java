package com.murder.runnables;

import com.murder.Murder;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.List;


public class WaitingRoom extends BukkitRunnable {
    private final World world;
    private final int stage;
    private int time;
    public WaitingRoom(World world, int stage) {
        this.world = world;
        this.stage = stage;
    }
    public void run() {
        switch (stage) {
            case 1:
                time = 60;
                break;
            case 2:
                time = 30;
                break;
            case 3:
                time = 15;
                break;
            case 4:
                time = 10;
                break;
            case 5:
                time = 5;
                break;
        }
        List<Player> players = world.getPlayers();
        int mods = 0;
        for (Player player : players) {
            if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                mods++;
            }
        }
        int playersCount = players.size() - mods;
        if (playersCount >= 8) {
            new WaitingRoom(world, stage-1).runTaskAsynchronously(Murder.getMainPlugin());
        } else {
            new WaitingRoom(world, 5).runTaskLaterAsynchronously(Murder.getMainPlugin(), 5 * 20);
        }
    }
}

