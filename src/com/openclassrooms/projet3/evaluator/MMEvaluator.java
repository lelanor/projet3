package com.openclassrooms.projet3.evaluator;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;

public class MMEvaluator implements Evaluator {

    GameData gameData;

    public MMEvaluator(GameData pgameData) {
        this.gameData = pgameData;
    }

    @Override
    public boolean winningTest(int[] candidate) {
        boolean result = false;

        return result;
    }

    @Override
    public int[] analyse(int[] candidate) {
        return new int[0];
    }
}
