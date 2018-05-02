package com.openclassrooms.projet3.evaluator;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;

public class EvaluatorFactory {

    public Evaluator instantiateEvaluator(GameData gamedata){

        if (gamedata.getGameChoice() == 1){
            return new MMEvaluator(gamedata);
        }
        else if (gamedata.getGameChoice() == 2){
            return new CodexEvaluator(gamedata);
        }
        return null;
    }
}
