package com.pjem.agora.controller;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.model.Associates;
import com.pjem.agora.record.AssociatesRead;
import com.pjem.agora.record.AssociatesRegistration;
import com.pjem.agora.service.AssociateService;
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
public class AssociateController {

    private final AssociateService associateService;

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
    public ResponseEntity<Object> registerAssociate(@RequestBody AssociatesRegistration newAssociate) {
        try {
            Associates saved = associateService.registrerAssociate(newAssociate);
            return ResponseEntity.status(HttpStatus.CREATED).body("registro gravado com sucesso");
        } catch (ResourceAlreadyRegisteredException ex) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
        }
    }

    @GetMapping
    public List<AssociatesRead> getAllAssocaites(){
        return associateService.getAllAssocaites();
    }

    @GetMapping("/associado/{name}")
    public AssociatesRead getAssociate(@PathVariable String name){
        return associateService.getAssociate(name);
    }

    @PatchMapping("/{name}")
    public void updateAssociate(@RequestBody AssociatesRegistration associateUpdateDto,
                                                  @PathVariable String name){
        associateService.updateAssociate(associateUpdateDto, name);
    }

    @DeleteMapping("/{name}")
    public void deleteAssociate(@PathVariable String name){
        associateService.deleteAssociate(name);
    }

}
