package com.openclassrooms.projet3.evaluator;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;

public class CodexEvaluator implements Evaluator {

    GameData gameData;

    public CodexEvaluator(GameData pgameData) {
        this.gameData = pgameData;
    }

    @Override
    public boolean winningTest(int[] candidate) {
        boolean result = false;
        int count = 0;
        for(int i=0; i<candidate.length; i++) {
            if (candidate[i] == 0)
                count += 1;
        }
        if (count == gameData.getNumberOfCases())
            result = true;
        return result;
    }

    @Override
    public int[] analyse(int[] candidate) {
        return new int[0];
    }
}
