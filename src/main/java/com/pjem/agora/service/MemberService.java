package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Members;
import com.pjem.agora.record.MemberResponse;
import com.pjem.agora.record.MemberCreateRequest;
import com.pjem.agora.repository.MemberRepository;
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
public class MemberService {

    private final MemberRepository memberRepository;

    public Members registrerAssociate(MemberCreateRequest newAssociate) {
        Optional<Members> optionalAssociates = memberRepository.findByCpf(newAssociate.cpf());
        if (optionalAssociates.isPresent()) {
            throw new ResourceAlreadyRegisteredException("Associado já cadastrado.");
        } else {
            Members members = new Members();
            BeanUtils.copyProperties(newAssociate, members);
            members.setIsActive(true);
            memberRepository.save(members);
            return ResponseEntity.status(HttpStatus.CREATED).body(members).getBody();
        }
    }

    public List<MemberResponse> getAllAssocaites(){
        List<Members> listAssociates = memberRepository.findAll();
        if(listAssociates.isEmpty()){
            throw new ResourceNoRegisteredException("Não existem associados cadastrados.");
        }
        return listAssociates.stream()
                .map(MemberResponse:: new)
                .collect(Collectors.toList());
    }

    public MemberResponse getAssociate(String name){
      return memberRepository.findByNameContainingIgnoreCase(name)
              .map(MemberResponse::new)
              .orElseThrow(() -> new ResourceNoRegisteredException("Associado não cadastrado"));    }

    public ResponseEntity<Object> updateAssociate(MemberCreateRequest associateData, String name){
        Optional<Members> associateUpdate = memberRepository.findByNameContainingIgnoreCase(name);
        if(associateUpdate.isEmpty()){
            throw new ResourceNoRegisteredException("Associado não cadastrado");
        }else{
            Members members = new Members();
            BeanUtils.copyProperties(associateData, members);
            members.setId(associateUpdate.get().getId());
            memberRepository.save(members);
            return ResponseEntity.status(HttpStatus.OK).body("Associado alterado..");
        }
    }

    public ResponseEntity<Object> deleteAssociate(String name){
        Optional<Members> associateDelete = memberRepository.findByNameContainingIgnoreCase(name);
        if(associateDelete.isEmpty()){
            throw new ResourceNoRegisteredException("Associado não cadastrado");
        }else{
            memberRepository.deleteById(associateDelete.get().getId());
            return ResponseEntity.status(HttpStatus.OK).body("Associado excluído.");
        }
    }


}











