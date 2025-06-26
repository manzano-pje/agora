package com.pjem.agora.service;

import com.pjem.agora.exception.InternalServerErrorException;
import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Associates;
import com.pjem.agora.model.Direction;
import com.pjem.agora.record.DirectionFinalDate;
import com.pjem.agora.record.DirectorMemberRegistration;
import com.pjem.agora.record.DirectionReturn;
import com.pjem.agora.repository.AssociateRepository;
import com.pjem.agora.repository.DirectionRepository;
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
public class DirectionService {

        private final DirectionRepository directorRepository;
        private final ModelMapper mapper;
        private final AssociateRepository associateRepository;


    /**
     * register direction assiciate
     *
     * @param newMember newMember
     */
    public void registerDirectionAssiciate(DirectorMemberRegistration newMember) {
        Optional<Associates> associatesOptional = associateRepository.findByNameContainingIgnoreCase(newMember.associateName());
        if (associatesOptional.isEmpty()) {
            throw new ResourceNoRegisteredException("Associado não cadastrado.");
        } else {
            Optional<Direction> directionOptional = directorRepository.findByAssociates(associatesOptional.get());
            if (directionOptional.isPresent() && directionOptional.get().isActive()) {
                String function = String.valueOf(directionOptional.get().getRole());
                throw new ResourceAlreadyRegisteredException("Associado " + newMember.associateName() + " é " + function + " na diretoria atual.");
            }
        }
        Direction direction = new Direction();
        direction.setRole(newMember.directionEnum());
        direction.setAssociates(associatesOptional.get());
        direction.setActive(true);
        direction.setStartDate(LocalDate.now());

        direction.setActive(true);

        System.out.println("Role para salvar: '" + direction.getRole() + "' com length: " + direction.getRole().name().length());
        directorRepository.save(direction);
    }

    public List<DirectionReturn> getAllDirection(){
        List<Direction> directionList = directorRepository.findAllWithAssociates();
        if (directionList.isEmpty()) {
            throw new ResourceNoRegisteredException("Não há membros cadastrados na diretoria");
        }else{

            directionList = directionList.stream()
                    .sorted(Comparator.comparing(Direction::getStartDate)
                            .thenComparing(Direction::getRole))
                    .collect(Collectors.toList());


            return  directionList.stream()
                    .map(d -> new DirectionReturn(
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

    public List<DirectionReturn> getDirectorsByPeriod(LocalDate startDate, LocalDate endDate) {
        if(endDate.isBefore(startDate)){
            throw new ResourceNoRegisteredException("Data final deve ser maior que data inicial");
        }
        try {
            List<Direction> directionList = directorRepository.findAllDirectionByPeriod(startDate, endDate);
            if (directionList.isEmpty()) {
                throw new ResourceNoRegisteredException("Não existem Diretorias no período informado");
            }

            return directionList.stream()
                    .map(d -> new DirectionReturn(
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

    public void setEndDate(DirectionFinalDate directionFinalDate){
        if(directionFinalDate.endDate() == null){
            throw new ResourceNoRegisteredException("Data final não informada");
        }
        Optional<Direction> directionOptional = directorRepository.findById(directionFinalDate.idDirector());
        if (directionOptional.isEmpty()){
            throw new ResourceNoRegisteredException("Não existe diretor cadastrado");
        }else if (!directionOptional.get().isActive()){
            throw new ResourceNoRegisteredException("Diretor não está na diretoria.");
        }
        Direction direction = new Direction();
        direction = mapper.map(directionOptional, Direction.class);
        direction.setActive(false);
        directorRepository.save(direction);
    }
}
