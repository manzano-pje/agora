package com.pjem.agora.exception;

public class noRegisteredMembersException extends RuntimeException{
    public noRegisteredMembersException(){
        super("Não há membros cadastrados.");
    }

}
