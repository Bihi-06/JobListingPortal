package com.example.joblistingportal.entities;


import jakarta.persistence.*;
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
public class JobSeeker {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String resume;

    @ElementCollection
    private List<String> preferredDomains;

    @Enumerated
    private CurrentJob currentJob;

    @Embedded
    private ContactDetails contactDetails;
}
