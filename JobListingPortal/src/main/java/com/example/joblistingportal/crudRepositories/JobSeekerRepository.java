package com.example.joblistingportal.crudRepositories;

import com.example.joblistingportal.entities.JobSeeker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
}
