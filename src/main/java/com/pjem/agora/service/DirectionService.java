package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Associates;
import com.pjem.agora.model.Direction;
import com.pjem.agora.record.DirectorMemberRegistration;
import com.pjem.agora.repository.AssociateRepository;
import com.pjem.agora.repository.DirectionRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;


@Service
@AllArgsConstructor
public class DirectionService {

        private final DirectionRepository directorRepository;
        private final ModelMapper mapper;
        private final AssociateRepository associateRepository;


    public void registerDirectionAssiciate(DirectorMemberRegistration newMember) {
        Optional<Associates> associatesOptional = associateRepository.findByNameContainingIgnoreCase(newMember.associateName());
        if (associatesOptional.isEmpty()) {
            throw new ResourceNoRegisteredException("Associado não cadastrado.");
        } else {
            Optional<Direction> directionOptional = directorRepository.findByIdAssociates(associatesOptional.get().getId());
            if (directionOptional.isPresent() && directionOptional.get().isActive()) {
                String function = String.valueOf(directionOptional.get().getRole());
                throw new ResourceAlreadyRegisteredException("Associado " + newMember.associateName() + "é " + function + " na diretoria atual.");
            }
        }
        Direction direction = new Direction();
        direction.setRole(newMember.directionEnum());
        direction.setIdAssociates(associatesOptional.get().getId());
        direction.setActive(true);
        direction.setStartDate(LocalDate.now());

//        direction = mapper.map(newMember, Direction.class);
        direction.setActive(true);
        directorRepository.save(direction);
//        DirectorReturn directorReturn = mapper.map(direction, DirectorReturn.class);
//        return ResponseEntity.status(HttpStatus.CREATED).body(directorReturn);
    }
}
