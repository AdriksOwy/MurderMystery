package com.murder.managers;

import com.murder.objects.Game;
import org.bukkit.entity.Player;

import java.util.List;

public class GamesManager {

    private List<Game> gameList;

    public synchronized boolean addPlayerToGameOrCreateGame(Player player) {
        int lastIndex = gameList.size() - 1;
        Game game = gameList.get(lastIndex);
        if (game.getPlayersCount() < game.getMaxPlayers()) {
            return game.teleportPlayer(player);
        } else {
            Game newGame = createGameAndAddToList();
            return newGame.teleportPlayer(player);
        }
    }

    private Game createGameAndAddToList() {
        /*TODO
         * make class GameMap
        GameMap gameMap = GameMap.getRandom();
        Game game = new Game(gameMap, 12);
        gameList.add(game);
        return game;
         */
        return null;
    }

    public List<Game> getGames() {
        return gameList;
    }
}