package com.pjem.agora.controller;

import com.pjem.agora.record.BoardEndDate;
import com.pjem.agora.record.BoardMemberCreateRequest;
import com.pjem.agora.record.BoardResponse;
import com.pjem.agora.service.BoardService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/direction")
@CrossOrigin(origins = "*") //

public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Object> registerDirectionAssiciate(BoardMemberCreateRequest newDirector){
        boardService.registerDirectionAssiciate(newDirector);
        return ResponseEntity.status(HttpStatus.CREATED).body("Diretor cadastrado");
    }

    @GetMapping
    public List<BoardResponse> getAllDirection(){
        return boardService.getAllDirection();
    }

    @PostMapping("/listPeriod")
    public List<BoardResponse> getDirectorsByPeriod(LocalDate startDate, LocalDate endDate){
        return boardService.getDirectorsByPeriod(startDate, endDate);
    }

    @PatchMapping("/endDate")
    public void setEndDate(@RequestBody BoardEndDate boardEndDate){
        boardService.setEndDate(boardEndDate);
    }

}
