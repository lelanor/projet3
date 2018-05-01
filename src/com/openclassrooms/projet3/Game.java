package com.openclassrooms.projet3;

import com.openclassrooms.projet3.com.openclassrooms.projet3.data.GameData;
import com.openclassrooms.projet3.exceptions.NotInCodeRangeException;
import com.openclassrooms.projet3.players.CPU;
import com.openclassrooms.projet3.players.Human;
import com.openclassrooms.projet3.players.Player;

import java.util.Arrays;
import java.util.Scanner;

public class Game {

    GameData gameData = new GameData();
    Player humanPlayer, CPUPlayer;
    Scanner keyboard = new Scanner(System.in);
    String userEntry;
    int[] result;


    public void initialDataRequest() {

        do {
            try {
                System.out.print("Voulez-vous jouer au MASTER MIND (choix 1) ou au CODEX (choix 2)? ");
                userEntry = keyboard.nextLine();
                gameData.setGameChoice(Integer.valueOf(userEntry));
            } catch (NumberFormatException e) {
                System.out.print("entrez un chiffre svp. ");
                gameData.setGameChoice(0);
            }
            if (gameData.getGameChoice() != 1 & gameData.getGameChoice() != 2) {
                System.out.println("Le choix doit être 1 ou 2. Retentez à nouveau, svp");
            }
        } while (gameData.getGameChoice() != 1 & gameData.getGameChoice() != 2);
        do {
            try {
                System.out.print("Voulez-vous attaquer (choix 1) ou defendre (choix 2) ?");
                userEntry = keyboard.nextLine();
                gameData.setHumanRoleChoice(Integer.valueOf(userEntry));
            } catch (NumberFormatException e) {
                System.out.print("entrez un chiffre svp. " +
                        "");
                gameData.setHumanRoleChoice(0);
            }
            if (gameData.getHumanRoleChoice() != 1 & gameData.getHumanRoleChoice() != 2) {
                System.out.println("Le choix doit être 1 ou 2. Retentez à nouveau, svp");
            }
        } while (gameData.getHumanRoleChoice() != 1 & gameData.getHumanRoleChoice() != 2);
        do {
            try {
                System.out.print("Voulez-vous un code de combien de chiffres ?");
                userEntry = keyboard.nextLine();
                gameData.setNumberOfCases(Integer.valueOf(userEntry));
            } catch (NumberFormatException e) {
                System.out.print("entrez un chiffre svp. " +
                        "");
                gameData.setNumberOfCases(0);
            }
            if (gameData.getNumberOfCases() == 0) {
                System.out.println("Le nombre de chiffres du code ne peut pas être nul. Retentez à nouveau, svp");
            }
        } while (gameData.getNumberOfCases() == 0);
        do {
            try {
                System.out.print("Quel range de chiffres voulez-vous ?");
                userEntry = keyboard.nextLine();
                gameData.setRange(Integer.valueOf(userEntry));
            } catch (NumberFormatException e) {
                System.out.print("entrez un chiffre svp. " +
                        "");
                gameData.setRange(0);
            }
            if (gameData.getRange() == 0) {
                System.out.println("L'amplitude de chiffres du code ne peut pas être nul. Retentez à nouveau, svp");
            }
        } while (gameData.getRange() == 0);
    }

    public void setPlayersAndCode() {

        humanPlayer = new Human(gameData);
        CPUPlayer = new CPU(gameData);

        if (gameData.getGameChoice() == 1)
            result = new int[2];
        else
            result = new int[gameData.getNumberOfCases()];

        if (gameData.getHumanRoleChoice() == 2) {
            gameData.setCodeToGuess(askForCode(gameData, humanPlayer));
        } else {
            try {
                gameData.setCodeToGuess(CPUPlayer.createCode());
            } catch (NotInCodeRangeException e) {
            }
        }
    }

    public void playGame() {

        System.out.println("Nous sommes donc prêts pour jouer!");
        System.out.println();
        System.out.print("Voulez vous afficher le code à deviner à des f" +
                "ins de debug (oui = 1/non = 2) ? ");
        int entree = keyboard.nextInt();
        if (entree == 1) {
            System.out.print("le code à donc une valeur de :");
            for (int i = 0; i < gameData.getNumberOfCases(); i++)
                System.out.print(gameData.getCodeToGuess()[i]);
            System.out.println();
        }
        if (gameData.getHumanRoleChoice() == 1) {
            Integer[] candidate;
            boolean notWon = true;
            do {
                candidate = askForCode(gameData, humanPlayer);
                result = CPUPlayer.analyse(candidate);
                if (winningTest(result)){
                    System.out.println("won");
                    notWon = false;
                }

            } while (notWon);
        }
        for (int i = 0; i < gameData.getNumberOfCases(); i++)
            System.out.print(result[i]);
    }


    public boolean winningTest(int[] candidate){
        boolean result = false;
        int count = 0;
        for(int i=0; i<gameData.getNumberOfCases(); i++) {
            if (candidate[i] == 0)
                count += 1;
        }
        if (count == gameData.getNumberOfCases())
            result = true;
        return result;
    }


    public Integer[] askForCode(GameData gameData, Player humanPlayer){
        Integer[] code = new Integer[gameData.getNumberOfCases()];
        boolean notOK;
        do {
            try {
                notOK = false;
                code = humanPlayer.createCode();
            } catch (NotInCodeRangeException e) {
                System.out.println(e.getMessage());
                notOK = true;
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("votre combinaison ne respecte pas la longueur autorisée");
                notOK = true;
            }
        } while (notOK);
        return code;
    }

}
