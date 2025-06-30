package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Board;
import com.pjem.agora.record.BoardCreateRequest;
import com.pjem.agora.record.BoardResponse;
import com.pjem.agora.repository.BoardRepository;
import com.pjem.agora.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 * Board service
 */
@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final Util util;


    public void CreateBoard(BoardCreateRequest newBoard) {
        util.validacaoDeDatas(newBoard.startDate(), newBoard.finalDate());
        Optional<Board> boardOptional = boardRepository.findByMandateStartLessThanEqualAndMandateEndGreaterThanEqual(newBoard.startDate(), newBoard.finalDate());
        if (boardOptional.isPresent()) {
            throw new ResourceAlreadyRegisteredException("Já existe uma gestão entre as datas inseridas.");
        } else {
            Board board = new Board();
            board.setMandateStart(newBoard.startDate());
            board.setMandateEnd(newBoard.finalDate());
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


}
