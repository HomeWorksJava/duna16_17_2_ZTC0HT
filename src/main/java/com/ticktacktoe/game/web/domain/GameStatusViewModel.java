package com.ticktacktoe.game.web.domain;

public class GameStatusViewModel {

    private String[][] gameField;
    private String currPlayer;


    public String[][] getGameField() {
        return gameField;
    }

    public void setGameField(String[][] gameField) {
        this.gameField = gameField;
    }

    public String getCurrPlayer() {
        return currPlayer;
    }

    public void setCurrPlayer(String currPlayer) {
        this.currPlayer = currPlayer;
    }
}
