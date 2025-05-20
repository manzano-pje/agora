package com.pjem.agora.service;

import com.pjem.agora.exception.MemberAlreadyRegisteredException;
import com.pjem.agora.exception.noRegisteredMembersException;
import com.pjem.agora.model.Associates;
import com.pjem.agora.record.AssociatesReadRecord;
import com.pjem.agora.record.AssociatesRegistrationRecord;
import com.pjem.agora.repository.AssociateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


/**
 *  associate service
 *  Formnatos para retorno de dados diferenciados
 *  busca individual de forma menos verbosa (clean code)
 */

@Service
@RequiredArgsConstructor
public class AssociateService {

    private final AssociateRepository associateRepository;

    public Associates registrerAssociate(AssociatesRegistrationRecord newAssociate) {
        Optional<Associates> optionalAssociates = associateRepository.findByNameContainingIgnoreCase(newAssociate.name());
        if (optionalAssociates.isPresent()) {
            throw new MemberAlreadyRegisteredException();
        } else {
            Associates associates = new Associates();
            BeanUtils.copyProperties(newAssociate, associates);
            associateRepository.save(associates);
//            System.out.println("Associado cadastrado com sucesso");
            return ResponseEntity.status(HttpStatus.CREATED).body(associates).getBody();
        }
    }

    public List<AssociatesReadRecord> getAllAssocaites(){
        List<Associates> listAssociates = associateRepository.findAll();
        if(listAssociates.isEmpty()){
            throw new noRegisteredMembersException();
        }
        return listAssociates.stream()
                .map(AssociatesReadRecord:: new)
                .collect(Collectors.toList());
    }

    public AssociatesReadRecord getAssociate(String name){
      return associateRepository.findByNameContainingIgnoreCase(name)
              .map(AssociatesReadRecord::new)
              .orElseThrow(noRegisteredMembersException::new);
    }

    public ResponseEntity<Object> updateAssociate(AssociatesRegistrationRecord associateData, String name){
        Optional<Associates> associateUpdate = associateRepository.findByNameContainingIgnoreCase(name);
        if(associateUpdate.isEmpty()){
            throw new noRegisteredMembersException();
        }else{
            Associates associates = new Associates();
            BeanUtils.copyProperties(associateData, associates);
            associates.setId(associateUpdate.get().getId());
            associateRepository.save(associates);
            return ResponseEntity.status(HttpStatus.OK).body("Associado alterado..");
        }
    }

    public ResponseEntity<Object> deleteAssociate(String name){
        Optional<Associates> associateDelete = associateRepository.findByNameContainingIgnoreCase(name);
        if(associateDelete.isEmpty()){
            throw new noRegisteredMembersException();
        }else{
            associateRepository.deleteById(associateDelete.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Associado excluído.");
        }
    }


}











