package com.example.joblistingportal.crudRepositories;

import com.example.joblistingportal.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
