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
    private int delay;

    public void startUpdates(int gameID) {
        new UpdatePlayersCount(gameID, world).runTaskTimerAsynchronously(Murder.getMainPlugin(), 0, 10);
    }

    public WaitingRoom(World world, int stage) {

        this.world = world;
        this.stage = stage;
    }

    public void run() {
        updateTimeAndDelay();
        List<Player> players = world.getPlayers();
        if (stage != 6) {
            int mods = 0;
            for (Player player : players) {
                if (player.hasPotionEffect(PotionEffectType.INVISIBILITY)) {
                    mods++;
                }
            }

            int playersCount = players.size() - mods;

            if (playersCount >= 1) {
                sendToAll("Gra rozpocznie się za "+time+" sekund");
                new WaitingRoom(world, stage + 1).runTaskLaterAsynchronously(Murder.getMainPlugin(), delay * 20L);
            }
            else {
                new WaitingRoom(world, 1).runTaskLaterAsynchronously(Murder.getMainPlugin(), 5 * 20);
                if (stage != 1) {
                    sendToAll("Rozpoczecie gry zostalo przerwane");
                }
            }
        } else {
            sendToAll("Gra właśnie się rozpoczęła");
            // game init here
        }
    }

    private void sendToAll(String message) {
        List<Player> players = world.getPlayers();
        players.forEach(player -> player.sendMessage(message));
    }

    private void updateTimeAndDelay() {
        switch (stage) {
            case 1:
                time = 60;
                delay = 30;
                break;
            case 2:
                time = 30;
                delay = 15;
                break;
            case 3:
                time = 15;
                delay = 5;
                break;
            case 4:
                time = 10;
                delay = 5;
                break;
            case 5:
                time = 5;
                delay = 5;
                break;
        }
    }
}

class UpdatePlayersCount extends BukkitRunnable {
    private final World world;
    private final int gameID;
    public UpdatePlayersCount(int gameID, World world) {
        this.gameID = gameID;
        this.world = world;
    }
    public void run() {
        if (Murder.getGamesManager().getGames().get(gameID).isGameStarted()) {
            this.cancel();
        }
        Murder.getGamesManager().getGames().get(gameID).setPlayersCount(world.getPlayerCount());
    }
}
