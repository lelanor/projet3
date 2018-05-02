package com.openclassrooms.projet3.players;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;
import com.openclassrooms.projet3.exceptions.NotInCodeRangeException;

import java.util.Scanner;

public class Human extends Player {

    public Human(GameData pGameData) {
        super(pGameData);
    }

    @Override
    public Integer[] createCode() throws NotInCodeRangeException
    {
        Integer[] code = new Integer[this.gameData.getNumberOfCases()];
        String userEntry;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Entrez une combinaison valable (" + this.gameData.getNumberOfCases() + " chiffres, entre 0 et " + this.gameData.getRange() + ")");
        userEntry = keyboard.nextLine();
        for (int i=0; i<userEntry.length(); i++){
            String n = userEntry.substring(i,i+1);
            try {
                code[i] = Integer.parseInt(n);
            }catch (NumberFormatException e){
                throw new NotInCodeRangeException();
            }
            if (code[i]>gameData.getRange())
                throw new NotInCodeRangeException();
        }
        return code;
    }

    /*@Override
    public int[] analyse(Integer[] candidate) {
        return new int[0];
    }*/
}
