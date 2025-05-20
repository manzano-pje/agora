package com.pjem.agora.record;

/**
 *  error response
 * Como utilizar um record para retornas os dados ao invés de um DTO
 */
public record ErrorResponse(
    Integer codigo,
    String mensagem
    ){
}