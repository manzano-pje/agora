package com.pjem.agora.service;

import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Projects;
import com.pjem.agora.record.ProjectRead;
import com.pjem.agora.record.ProjectRegistration;
import com.pjem.agora.repository.ProjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    public Projects projectRegiostration(ProjectRegistration newProject){
        Optional<Projects> projectsOptional = projectRepository.findByName(newProject.name());
        if(projectsOptional.isPresent()){
            throw new ResourceAlreadyRegisteredException("Projeto já cadastrado.");
        }
        Projects projects = new Projects();
        projects.setName(newProject.name());
        projects.setStartDate(newProject.startDate());
        return projectRepository.save(projects);
    }

    public List<ProjectRead> getAllProjects(){
        List<Projects> projectsList = projectRepository.findAll();
        if (projectsList.isEmpty()) {
            throw new ResourceNoRegisteredException("Não existem projetos cadastrados.");
        }
        else{
            return projectsList.stream()
                    .map(ProjectRead :: from)
                    .sorted(Comparator.comparing(ProjectRead::name))
                    .collect(Collectors.toList());
        }
    }



}
