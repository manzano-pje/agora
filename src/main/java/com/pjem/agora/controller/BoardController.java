package com.pjem.agora.controller;

import com.pjem.agora.record.BoardCreateRequest;
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
@RequestMapping("api/v1/board")
@CrossOrigin(origins = "*") //

public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity<Object> CreateBoard(BoardCreateRequest newBoard){
        boardService.CreateBoard(newBoard);
        return ResponseEntity.status(HttpStatus.CREATED).body("Gestão cadastrado");
    }

    @GetMapping
    public List<BoardResponse> getAllBoards(){
        return boardService.getAllBoards();
    }

//    @PostMapping("/listPeriod")
//    public List<BoardResponse> getDirectorsByPeriod(LocalDate startDate, LocalDate endDate){
//        return boardService.getMemberByPeriod(startDate, endDate);
//    }
//
//    @PatchMapping("/endDate")
//    public void setEndDate(@RequestBody BoardEndDate boardEndDate){
//        boardService.setEndDate(boardEndDate);
//    }

}
