package com.practice.solarmng.services;

import com.practice.solarmng.entity.ProjectEntity;
import com.practice.solarmng.model.Project;
import com.practice.solarmng.repository.ProjectRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl implements ProjectService{
    private ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @Override
    public Project createProject(Project project) {
        ProjectEntity projectEntity = new ProjectEntity();

        BeanUtils.copyProperties(project,projectEntity);
        projectRepository.save(projectEntity);

        return project;
    }

    @Override
    public List<Project> getProjects(long userid) {
        Optional<List<ProjectEntity>> optionalProjectEntity = projectRepository.findByUserId(userid);

        List<ProjectEntity> projectEntity = optionalProjectEntity.get();
        List<Project> projects = projectEntity.stream()
                .map(this::convertToProject)
                .collect(Collectors.toList());

        return projects;
    }

    private Project convertToProject(ProjectEntity projectEntity) {
        Project project = new Project();
        BeanUtils.copyProperties(projectEntity, project);
        return project;
    }
}
