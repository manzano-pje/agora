package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Associates;
import com.pjem.agora.model.Direction;
import com.pjem.agora.record.DirectorMemberRegistration;
import com.pjem.agora.record.DirectionReturn;
import com.pjem.agora.repository.AssociateRepository;
import com.pjem.agora.repository.DirectionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
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
                throw new ResourceAlreadyRegisteredException("Associado " + newMember.associateName() + "é " + function + " na diretoria atual.");
            }
        }
        Direction direction = new Direction();
        direction.setRole(newMember.directionEnum());
        direction.setAssociates(associatesOptional.get());
        direction.setActive(true);
        direction.setStartDate(LocalDate.now());

        direction.setActive(true);
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
                            d.getRole(),
                            d.getAssociates().getName(),
                            d.getStartDate(),
                            d.getFinalDate(),
                            d.isActive()
                            )
                    )
                    .collect(Collectors.toList());
        }

    }
}
