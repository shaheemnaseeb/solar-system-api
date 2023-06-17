package com.practice.solarmng.controller;

import com.practice.solarmng.model.Project;
import com.practice.solarmng.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@RestController
@RequestMapping("/api/v1/")
public class ProjectController {
    @Autowired
    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @PostMapping("/project")
    public ResponseEntity<Project> createUser(@RequestBody Project project) {
        Project createdProject = projectService.createProject(project);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdProject);
    }

    @GetMapping("/project/{userid}")
    public ResponseEntity<List<Project>> getUser(@PathVariable long userid) {
        List<Project> project = projectService.getProjects(userid);
        return ResponseEntity.ok(project);
    }
}
