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
public class Employer {
    @Id
    @GeneratedValue
    private Long id;
    private String companyName;

    @Enumerated(EnumType.STRING)
    private Industry industry;

    @Embedded
    private ContactDetails contactDetails;
}
