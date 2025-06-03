package com.pjem.agora.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/direction")
public class DirectionController {

//    private final DirectionService directionService;

//    @PostMapping
//    public ResponseEntity<Object> registerDirectionAssiciate(DirectorMemberRegistration newDirector){
////        try {
////            Direction saved = directionService.registerDirectionAssiciate(newDirector);
////            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
////        } catch (MemberAlreadyRegisteredException ex) {
////            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
////        }
//    }
}
