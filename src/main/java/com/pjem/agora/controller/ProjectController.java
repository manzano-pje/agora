package com.pjem.agora.controller;

import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Projects;
import com.pjem.agora.record.ProjectRead;
import com.pjem.agora.record.ProjectRegistration;
import com.pjem.agora.service.ProjectService;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/projects")
@Table(name="tb_projects")
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping
    public ResponseEntity<Object> projectRegistration(@RequestBody ProjectRegistration newProject) {
        Projects saved = projectService.projectRegiostration(newProject);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved + "Projeto cadastrado");
    }

    @GetMapping
    public List<ProjectRead> getAllProjects(){
        return projectService.getAllProjects();
    }



}
