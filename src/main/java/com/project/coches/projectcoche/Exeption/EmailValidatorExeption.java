package com.project.coches.projectcoche.Exeption;

public class EmailValidatorExeption extends  RuntimeException{
    public EmailValidatorExeption(){
        super("el email no tiene el formatorequerido");
    }
}
