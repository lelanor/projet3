package com.openclassrooms.projet3.exceptions;

public class NotInCodeRangeException extends Exception {


    public NotInCodeRangeException(){
        super("Dans votre code il y a un chiffre qui depasse l'amplitude autorisé");
    }
}
