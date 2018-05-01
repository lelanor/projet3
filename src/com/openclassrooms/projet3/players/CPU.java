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

}
