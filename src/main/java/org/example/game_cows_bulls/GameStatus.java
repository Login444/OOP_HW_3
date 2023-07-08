package org.example.game_cows_bulls;

public enum GameStatus {
    INIT("Инициализация"), START("Начало игры"), WIN("Победа"), FINISH("Конец игры");

    String status;

    GameStatus(String status) {
        this.status = status;
    }

    GameStatus() {
    }
}
