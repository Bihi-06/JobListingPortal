package com.example.joblistingportal.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Application {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name= "job_listing_id")
    private JobListing jobListing;

    @OneToOne
    private JobSeeker jobSeeker;
}
