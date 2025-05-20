package com.pjem.agora.exception;

public class MemberAlreadyRegisteredException extends RuntimeException{
    public MemberAlreadyRegisteredException() {
        super("Membro já cadastrado.");
    }

}
