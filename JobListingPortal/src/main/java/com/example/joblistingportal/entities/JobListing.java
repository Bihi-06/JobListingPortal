package com.example.joblistingportal.entities;


import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JobListing {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String description;
    private String location;
    private String salary;
    private String pictureUrl;
    private String domain;
}

