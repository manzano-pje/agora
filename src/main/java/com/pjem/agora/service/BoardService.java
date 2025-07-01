package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Board;
import com.pjem.agora.record.BoardCreateRequest;
import com.pjem.agora.record.BoardUpdateRequest;
import com.pjem.agora.record.BoardResponse;
import com.pjem.agora.repository.BoardRepository;
import com.pjem.agora.util.Util;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
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
        util.validacaoDeDatas(newBoard.mandateStart(), newBoard.mandateEnd());
        List<Board> boardList = boardRepository.findByManagementPeriod(newBoard.mandateStart(), newBoard.mandateEnd());
        if (!boardList.isEmpty()) {
            throw new ResourceAlreadyRegisteredException("Já existe uma gestão entre as datas inseridas.");
        } else {
            Board board = new Board();
            board.setMandateStart(newBoard.mandateStart());
            board.setMandateEnd(newBoard.mandateEnd());
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

    public void updateManagement(Long idBoard, BoardUpdateRequest newBoard){
        util.validacaoDeDatas(newBoard.managementStart(),newBoard.managementEnd());
        List<Board> boardManagementList = boardRepository.findByManagementPeriod(newBoard.managementStart(), newBoard.managementEnd());
        if (!boardManagementList.isEmpty()) {
            throw new ResourceAlreadyRegisteredException("Já existe uma gestão entre as datas inseridas.");
        }else {
            Optional<Board> boardIdOptional = boardRepository.findById(idBoard);
            if (boardIdOptional.isEmpty()) {
                throw new ResourceNoRegisteredException("Não existe nenhuma gestão cadastrada");
            } else {
                Board board = new Board();
                board.setIdBoard(idBoard);
                board.setMandateStart(newBoard.managementStart());
                board.setMandateEnd(newBoard.managementEnd());
                board.setActive(newBoard.isActive());
                boardRepository.save(board);
            }
        }
    }

    public void deleteBoard(Long idBoard){
        Optional<Board> boardIdOptional = boardRepository.findById(idBoard);
        if (boardIdOptional.isEmpty()) {
            throw new ResourceNoRegisteredException("Não existe nenhuma gestão cadastrada");
        } else {
            try{
                boardRepository.deleteById(idBoard);
            }catch (DataIntegrityViolationException e){
                throw new DataIntegrityViolationException("ão é possível excluir esta gestão pois há membros vinculados.");
            }
        }
    }
}
