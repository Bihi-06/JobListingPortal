package com.example.joblistingportal.crudRepositories;

import com.example.joblistingportal.entities.Experience;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExperienceRepository extends JpaRepository<Experience, Long> {
}
