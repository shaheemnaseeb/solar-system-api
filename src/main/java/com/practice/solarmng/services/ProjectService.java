package com.practice.solarmng.services;

import com.practice.solarmng.model.Project;

import java.util.List;
import java.util.Optional;
public interface ProjectService {
    Project createProject(Project project);

    List<Project> getProjects(long userid);
}
