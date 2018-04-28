package com.openclassrooms.projet3.players;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;
import com.openclassrooms.projet3.exceptions.NotInCodeRangeException;

public abstract class Player {

    GameData gameData;

    public Player(GameData pGameData){
        this.gameData = pGameData;
    }

    public abstract Integer[] createCode() throws NotInCodeRangeException;

    public abstract int[] analyse(Integer[] candidate);
}
