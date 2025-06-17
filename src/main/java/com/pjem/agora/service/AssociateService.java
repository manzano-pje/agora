package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Associates;
import com.pjem.agora.record.AssociatesRead;
import com.pjem.agora.record.AssociatesRegistration;
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

    public Associates registrerAssociate(AssociatesRegistration newAssociate) {
        Optional<Associates> optionalAssociates = associateRepository.findByNameContainingIgnoreCase(newAssociate.name());
        if (optionalAssociates.isPresent()) {
            throw new ResourceAlreadyRegisteredException("Associado já cadastrado.");
        } else {
            Associates associates = new Associates();
            BeanUtils.copyProperties(newAssociate, associates);
            associates.setIsActive(true);
            associateRepository.save(associates);
            return ResponseEntity.status(HttpStatus.CREATED).body(associates).getBody();
        }
    }

    public List<AssociatesRead> getAllAssocaites(){
        List<Associates> listAssociates = associateRepository.findAll();
        if(listAssociates.isEmpty()){
            throw new ResourceNoRegisteredException("Não existem associados cadastrados.");
        }
        return listAssociates.stream()
                .map(AssociatesRead:: new)
                .collect(Collectors.toList());
    }

    public AssociatesRead getAssociate(String name){
      return associateRepository.findByNameContainingIgnoreCase(name)
              .map(AssociatesRead::new)
              .orElseThrow(() -> new ResourceNoRegisteredException("Associado não cadastrado"));    }

    public ResponseEntity<Object> updateAssociate(AssociatesRegistration associateData, String name){
        Optional<Associates> associateUpdate = associateRepository.findByNameContainingIgnoreCase(name);
        if(associateUpdate.isEmpty()){
            throw new ResourceNoRegisteredException("Associado não cadastrado");
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
            throw new ResourceNoRegisteredException("Associado não cadastrado");
        }else{
            associateRepository.deleteById(associateDelete.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Associado excluído.");
        }
    }


}











