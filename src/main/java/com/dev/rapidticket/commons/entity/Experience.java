package com.dev.rapidticket.commons.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "experiences")
@Data
public class Experience {

    @Id
    @Column(name = "experience_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer experienceId;

    @Column(name = "experience_name")
    private String experienceName;
}
