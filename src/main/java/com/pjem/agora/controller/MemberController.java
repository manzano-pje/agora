package com.pjem.agora.controller;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.model.Members;
import com.pjem.agora.record.MemberResponse;
import com.pjem.agora.record.MemberCreateRequest;
import com.pjem.agora.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/associate")
@CrossOrigin(origins = "*") //
public class MemberController {

    private final MemberService memberService;

    /***
     *
     * @param newAssociate
     * @return
     *
     * Aprendizadp:
     * Try-catch
     * Anotações
     */

    @PostMapping
    public ResponseEntity<Object> registerAssociate(@RequestBody MemberCreateRequest newAssociate) {
        try {
            Members saved = memberService.registrerAssociate(newAssociate);
            return ResponseEntity.status(HttpStatus.CREATED).body("registro gravado com sucesso");
        } catch (ResourceAlreadyRegisteredException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping
    public List<MemberResponse> getAllAssocaites(){
        return memberService.getAllAssocaites();
    }

    @GetMapping("/associado/{name}")
    public MemberResponse getAssociate(@PathVariable String name){
        return memberService.getAssociate(name);
    }

    @PatchMapping("/{name}")
    public void updateAssociate(@RequestBody MemberCreateRequest associateUpdateDto,
                                                  @PathVariable String name){
        memberService.updateAssociate(associateUpdateDto, name);
    }

    @DeleteMapping("/{name}")
    public void deleteAssociate(@PathVariable String name){
        memberService.deleteAssociate(name);
    }

}
