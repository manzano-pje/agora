package com.pjem.agora.service;

import com.pjem.agora.exception.InternalServerErrorException;
import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Board;
import com.pjem.agora.model.Members;
import com.pjem.agora.record.BoardEndDate;
import com.pjem.agora.record.BoardMemberCreateRequest;
import com.pjem.agora.record.BoardResponse;
import com.pjem.agora.repository.MemberRepository;
import com.pjem.agora.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 *  direction service
 *
 */
@Service
@AllArgsConstructor
public class BoardService {

        private final BoardRepository directorRepository;
        private final ModelMapper mapper;
        private final MemberRepository memberRepository;


    /**
     * register direction assiciate
     *
     * @param newMember newMember
     */
    public void registerDirectionAssiciate(BoardMemberCreateRequest newMember) {
        Optional<Members> associatesOptional = memberRepository.findByNameContainingIgnoreCase(newMember.associateName());
        if (associatesOptional.isEmpty()) {
            throw new ResourceNoRegisteredException("Associado não cadastrado.");
        } else {
            Optional<Board> directionOptional = directorRepository.findByAssociates(associatesOptional.get());
            if (directionOptional.isPresent() && directionOptional.get().isActive()) {
                String function = String.valueOf(directionOptional.get().getRole());
                throw new ResourceAlreadyRegisteredException("Associado " + newMember.associateName() + " é " + function + " na diretoria atual.");
            }
        }
        Board board = new Board();
        board.setRole(newMember.boardRole());
        board.setAssociates(associatesOptional.get());
        board.setActive(true);
        board.setStartDate(LocalDate.now());

        board.setActive(true);

        System.out.println("Role para salvar: '" + board.getRole() + "' com length: " + board.getRole().name().length());
        directorRepository.save(board);
    }

    public List<BoardResponse> getAllDirection(){
        List<Board> boardList = directorRepository.findAllWithAssociates();
        if (boardList.isEmpty()) {
            throw new ResourceNoRegisteredException("Não há membros cadastrados na diretoria");
        }else{

            boardList = boardList.stream()
                    .sorted(Comparator.comparing(Board::getStartDate)
                            .thenComparing(Board::getRole))
                    .collect(Collectors.toList());


            return  boardList.stream()
                    .map(d -> new BoardResponse(
                            d.getAssociates().getName(),
                            d.getRole(),
                            d.getStartDate(),
                            d.getFinalDate(),
                            d.isActive()
                            )
                    )
                    .collect(Collectors.toList());
        }
    }

    public List<BoardResponse> getDirectorsByPeriod(LocalDate startDate, LocalDate endDate) {
        if(endDate.isBefore(startDate)){
            throw new ResourceNoRegisteredException("Data final deve ser maior que data inicial");
        }
        try {
            List<Board> boardList = directorRepository.findAllDirectionByPeriod(startDate, endDate);
            if (boardList.isEmpty()) {
                throw new ResourceNoRegisteredException("Não existem Diretorias no período informado");
            }

            return boardList.stream()
                    .map(d -> new BoardResponse(
                            d.getAssociates().getName(),
                            d.getRole(),
                            d.getStartDate(),
                            d.getFinalDate(),
                            d.isActive()
                    ))
                    .collect(Collectors.toList());
        }catch (DataAccessException e){
            throw new InternalServerErrorException("Erro ao ler os dados. Por favor tente mais tarde.");
        }
    }

    public void setEndDate(BoardEndDate boardEndDate){
        if(boardEndDate.endDate() == null){
            throw new ResourceNoRegisteredException("Data final não informada");
        }
        Optional<Board> directionOptional = directorRepository.findById(boardEndDate.idDirector());
        if (directionOptional.isEmpty()){
            throw new ResourceNoRegisteredException("Não existe diretor cadastrado");
        }else if (!directionOptional.get().isActive()){
            throw new ResourceNoRegisteredException("Diretor não está na diretoria.");
        }
        Board board = new Board();
        board = mapper.map(directionOptional, Board.class);
        board.setActive(false);
        directorRepository.save(board);
    }
}
