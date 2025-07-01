package com.pjem.agora.controller;

import com.pjem.agora.record.BoardCreateRequest;
import com.pjem.agora.record.BoardUpdateRequest;
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
    public ResponseEntity<Object> CreateBoard(@RequestBody BoardCreateRequest newBoard){
        boardService.CreateBoard(newBoard);
        return ResponseEntity.status(HttpStatus.CREATED).body("Gestão cadastrado");
    }

    @GetMapping
    public List<BoardResponse> getAllBoards(){
        return boardService.getAllBoards();
    }

    @GetMapping("/listPeriod")
    public List<BoardResponse> getDirectorsByPeriod(@RequestParam LocalDate managementStart,
                                                    @RequestParam LocalDate managementEnd){

        return boardService.getDirectorsByPeriod(managementStart, managementEnd);
    }

    @PatchMapping("{idBoard}")
    public void updateManagement(@PathVariable Long idBoard, @RequestBody BoardUpdateRequest newBoard){
        boardService.updateManagement(idBoard,newBoard );

    }

    @DeleteMapping("{idBoard}")
    public void deleteBoard(@PathVariable Long idBoard){
        boardService.deleteBoard(idBoard);
    }

}
