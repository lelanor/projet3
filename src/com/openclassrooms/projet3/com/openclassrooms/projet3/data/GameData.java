package com.openclassrooms.projet3.com.openclassrooms.projet3.data;

import java.util.List;

public class GameData {

    private Integer gameChoice;
    private Integer humanRoleChoice;
    private Integer numberOfCases;
    private Integer range;
    private Integer[] codeToGuess;
    private List possibleCombinations;

    public GameData(){
        this.setGameChoice(0);
    }

    public Integer getGameChoice() {
        return gameChoice;
    }

    public void setGameChoice(int gameChoice) {
        this.gameChoice = gameChoice;
    }

    public Integer getHumanRoleChoice() {
        return humanRoleChoice;
    }

    public void setHumanRoleChoice(int humanRoleChoice) {
        this.humanRoleChoice = humanRoleChoice;
    }

    public Integer getNumberOfCases() {
        return numberOfCases;
    }

    public void setNumberOfCases(int numberOfCases) {
        this.numberOfCases = numberOfCases;
    }

    public Integer getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public Integer[] getCodeToGuess() {
        return codeToGuess;
    }

    public void setCodeToGuess(Integer[] codeToGuess) {
        this.codeToGuess = codeToGuess;
    }

    public List getPossibleCombinations() {
        return possibleCombinations;
    }

    public void setPossibleCombinations(List possibleCombinations) {
        this.possibleCombinations = possibleCombinations;
    }
}
