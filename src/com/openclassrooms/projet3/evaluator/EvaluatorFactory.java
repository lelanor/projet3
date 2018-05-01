package com.openclassrooms.projet3.evaluator;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;

public class EvaluatorFactory {

    public Evaluator instantiateEvaluator(GameData gamedata){
        Evaluator evaluator = null;

        if (gamedata.getGameChoice() == 1){
            evaluator = new MMEvaluator(gamedata);
        }
        else if (gamedata.getGameChoice() == 2){
            evaluator = new CodexEvaluator(gamedata);
        }
        return evaluator;
    }
}
