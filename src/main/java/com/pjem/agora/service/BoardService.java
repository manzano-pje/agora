package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Board;
import com.pjem.agora.record.BoardFilterRequest;
import com.pjem.agora.record.BoardResponse;
import com.pjem.agora.repository.BoardRepository;
import com.pjem.agora.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


/**
 * Board service
 */
@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final Util util;


    public void CreateBoard(BoardFilterRequest newBoard) {
        util.validacaoDeDatas(newBoard.managementStart(), newBoard.managementEnd());
        List<Board> boardOptional = boardRepository.findByManagementPeriod(newBoard.managementStart(), newBoard.managementEnd());
        if (boardOptional.isEmpty()) {
            throw new ResourceAlreadyRegisteredException("Já existe uma gestão entre as datas inseridas.");
        } else {
            Board board = new Board();
            board.setMandateStart(newBoard.managementStart());
            board.setMandateEnd(newBoard.managementEnd());
            board.setActive(false);
            boardRepository.save(board);
        }
    }

    public List<BoardResponse> getAllBoards(){
        List<Board> boardList = boardRepository.findAll();
        if(boardList.isEmpty()){
            throw new ResourceNoRegisteredException("Não existe nenhuma gestão cadastrada.");
        }else{
            return boardList.stream()
                    .map(BoardResponse::new)
                    .collect(Collectors.toList());
        }
    }

    public List<BoardResponse> getDirectorsByPeriod(LocalDate managementStart, LocalDate managementEnd){
        util.validacaoDeDatas(managementStart, managementEnd);
        List<Board> boardList = boardRepository.findByManagementPeriod(managementStart, managementEnd);
        if(boardList.isEmpty()){
            throw new ResourceNoRegisteredException("Não existe nenhuma gestão cadastrada neste período.");
        }else{
            return boardList.stream()
                    .map(BoardResponse::new)
                    .collect(Collectors.toList());
        }
    }


}
