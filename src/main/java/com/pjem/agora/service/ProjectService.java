package com.pjem.agora.service;

import com.pjem.agora.dto.ProjectUpdateRequest;
import com.pjem.agora.exception.ResourceAlreadyRegisteredException;
import com.pjem.agora.exception.ResourceNoRegisteredException;
import com.pjem.agora.model.Projects;
import com.pjem.agora.record.ProjectResponse;
import com.pjem.agora.record.ProjectCreateRequest;
import com.pjem.agora.record.ProjetctDuration;
import com.pjem.agora.repository.ProjectRepository;
import lombok.AllArgsConstructor;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ModelMapper mapper;

    public Projects projectRegiostration(ProjectCreateRequest newProject){
        Optional<Projects> projectsOptional = projectRepository.findByName(newProject.name());
        if(projectsOptional.isPresent()){
            throw new ResourceAlreadyRegisteredException("Projeto já cadastrado.");
        }
        Projects projects = new Projects();
        projects.setName(newProject.name());
        projects.setStartDate(newProject.startDate());
        return projectRepository.save(projects);
    }

    public List<ProjectResponse> getAllProjects(){
        List<Projects> projectsList = projectRepository.findAll();
        if (projectsList.isEmpty()) {
            throw new ResourceNoRegisteredException("Não existem projetos cadastrados.");
        }
        else{
            return projectsList.stream()
                    .map(ProjectResponse:: from)
                    .sorted(Comparator.comparing(ProjectResponse::name))
                    .collect(Collectors.toList());
        }
    }

    public List<ProjectResponse> getProjectsByPeriod(ProjetctDuration projetctDuration){
        List<Projects> projectsList = projectRepository.findByPeriod(projetctDuration.startDate(),
                                                                     projetctDuration.endDate());
        if(projectsList.isEmpty()){
            throw new ResourceNoRegisteredException("Não existem projetos cadastrados neste período");
        }else{
            return projectsList.stream()
                    .map(ProjectResponse::from)
                    .collect(Collectors.toList());
        }
    }

    public void updateProject(String name, ProjectUpdateRequest newProject){
        Optional<Projects> projectsOptional = projectRepository.findByName(name);
        if(projectsOptional.isEmpty()){
            throw new ResourceNoRegisteredException("Projeto não cadastrado.");
        }else{
            Projects project = new Projects();
            BeanUtils.copyProperties(newProject, project);
            project.setId(projectsOptional.get().getId());
            projectRepository.save(project);
        }
    }

    public void endProject(String name, LocalDate endDate){
        Optional<Projects> projectsOptional = projectRepository.findByName(name);
        if (projectsOptional.isEmpty()){
            throw new ResourceNoRegisteredException("Projeto inexistente.");
        }else{

            Projects project = new Projects();
            project = mapper.map(projectsOptional.get(), Projects.class);
            project.setEndDate(endDate);
            projectRepository.save(project);
        }
    }




}
