package com.practice.solarmng.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="project")
public class ProjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private String createdAt;
    private boolean status;
    private long userId;
}
