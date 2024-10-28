package com.example.joblistingportal.crudRepositories;

import com.example.joblistingportal.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {
}
