package com.example.joblistingportal.crudRepositories;

import com.example.joblistingportal.entities.JobListing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobListingRepository extends JpaRepository<JobListing, Long> {
}
