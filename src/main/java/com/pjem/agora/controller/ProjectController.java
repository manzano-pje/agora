package com.pjem.agora.controller;

import com.pjem.agora.dto.ProjectUpdateDto;
import com.pjem.agora.record.ProjectRead;
import com.pjem.agora.record.ProjectRegistration;
import com.pjem.agora.record.ProjetctPeriod;
import com.pjem.agora.service.ProjectService;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/projects")
@CrossOrigin(origins = "*") //
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Object> projectRegistration(@Valid @RequestBody ProjectRegistration newProject) {
        projectService.projectRegiostration(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body("Projeto cadastrado");
    }

    @GetMapping
    public List<ProjectRead> getAllProjects(){
        return projectService.getAllProjects();
    }

    @PostMapping("/period")
    public List<ProjectRead> getProjectsByPeriod( @RequestBody ProjetctPeriod projetctPeriod){
        return projectService.getProjectsByPeriod(projetctPeriod);
    }

    @PatchMapping("/{name}")
    public ResponseEntity<Object> updateProject(@PathVariable String name,
                              @Valid @RequestBody ProjectUpdateDto newProject){
        projectService.updateProject(name, newProject);
        return ResponseEntity.status(HttpStatus.OK).body("Projeto atualizado.");
    }

    @PostMapping("/endDate/{name}")
    public ResponseEntity<Object> cancelProject(@PathVariable String name, LocalDate endDate){
        projectService.endProject(name, endDate);
        return ResponseEntity.status(HttpStatus.OK).body("Projeto encerrado.");
    }



}
