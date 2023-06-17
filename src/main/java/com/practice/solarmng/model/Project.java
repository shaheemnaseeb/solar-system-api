package com.practice.solarmng.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private long id;
    private String name;
    private String description;
    private String createdAt;
    private boolean status;
    private long userId;
}
