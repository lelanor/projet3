package com.openclassrooms.projet3.players;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;
import com.openclassrooms.projet3.exceptions.NotInCodeRangeException;

import java.util.Random;

public class CPU extends Player {

    public CPU(GameData pGameData) {

        super(pGameData);
    }

    @Override
    public Integer[] createCode() throws NotInCodeRangeException {

        Integer[] code = new Integer[gameData.getNumberOfCases()];
        Random random = new Random();

        for (int i=0; i<gameData.getNumberOfCases(); i++){
            code[i] = random.nextInt(gameData.getRange());
        }
        return code;
    }

    @Override
    public int[] analyse(Integer[] candidate) {

        int[] result;
        if (gameData.getGameChoice() == 1)
            result = new int[2];
        else {
            result = new int[gameData.getNumberOfCases()];
            for (int i = 0; i < gameData.getNumberOfCases(); i++) {
                result[i] = gameData.getCodeToGuess()[i].compareTo(candidate[i]);
                System.out.println(result[i]);
            }

        }
        return result;
    }
}
