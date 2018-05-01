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
        if ((candidate[0] == gameData.getNumberOfCases()) && (candidate[1] == 0)) {
            result = true;
        }
        return result;
    }

    @Override
    public int[] analyse(Integer[] candidate) {

        int[] result = new int[2];
        for (int  i=0; i<candidate.length; i++){
            if (candidate[i] == gameData.getCodeToGuess()[i]){
                result[0] += 1;
                candidate[i] = -1;
            }
        }

        for (int i = 0; i < candidate.length; i++) {
            for (int j = 0; j < candidate.length; j++ ) {
                if ( candidate[i] == gameData.getCodeToGuess()[j]) {
                    result[1] += 1;
                    candidate[j] = -1;
                }
            }
        }

        return result;
    }
}
