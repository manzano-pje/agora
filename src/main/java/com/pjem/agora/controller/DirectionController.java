package com.pjem.agora.controller;

import com.pjem.agora.record.DirectorMemberRegistration;
import com.pjem.agora.service.DirectionService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/direction")
@CrossOrigin(origins = "*") //

public class DirectionController {

    private final DirectionService directionService;

    @PostMapping
    public ResponseEntity<Object> registerDirectionAssiciate(DirectorMemberRegistration newDirector){
        directionService.registerDirectionAssiciate(newDirector);
        return ResponseEntity.status(HttpStatus.CREATED).body("Diretor cadastrado");
    }
}
