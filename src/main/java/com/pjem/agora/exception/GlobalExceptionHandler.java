package com.pjem.agora.exception;

import com.pjem.agora.record.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 *  global exception handler
 *  Forma de tratar excessões
 *  Anotações e métodos
 *
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Member Alread Registered
    @ExceptionHandler(MemberAlreadyRegisteredException.class)
    public ResponseEntity<ErrorResponse> handleMemberAlreadyRegistered(MemberAlreadyRegisteredException ex) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(new ErrorResponse(409, ex.getMessage()));
    }

    // No Registered Members
    @ExceptionHandler(noRegisteredMembersException.class)
    public ResponseEntity<ErrorResponse> handlenoRegisteredMembers(noRegisteredMembersException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new ErrorResponse(404, ex.getMessage()));
    }



    // Handling unexpected errors - Internal Server Error (500)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleInternalServerError(Exception ex) {
        ex.printStackTrace(); // ou use um logger
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new ErrorResponse(500, "Erro interno no servidor. Por favor, tente novamente mais tarde."));

}
}
