package ru.netology;

import lombok.Getter;

import java.util.HashMap;

import java.util.Map;

@Getter
public class Game {

    protected Map<String, Player> registeredPlayers;

    public Game() {
        this.registeredPlayers = new HashMap<>();
    }

    // Добавление в список зарегистрированных игроков
    public void addPlayer(Player player) {
        if (player == null) {
            throw new NotRegisteredException("Игрок c именем null не может быть зарегистрирован.");
        }
        if (registeredPlayers.containsKey(player.getName())) {
            throw new NotRegisteredException("Игрок с именем " + player.getName() + " уже зарегистрирован.");
        }
        registeredPlayers.put(player.getName(), player);
    }

    // Поиск по имени
    public Player findByName(String name) {
        if (name == null) {
            throw new NotRegisteredException("null не допустимое имя.");
        }
        return registeredPlayers.get(name);
    }

    //бойня
    public int round(String playerName1, String playerName2) throws NotRegisteredException {
        Player player1 = findByName(playerName1);
        Player player2 = findByName(playerName2);

        if (player1 == null) {
            throw new NotRegisteredException("Игрок " + playerName1 + " не может участвовать.");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Игрок " + playerName2 + " не может участвовать.");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        } else if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else {
            return 0;
        }
    }
}
