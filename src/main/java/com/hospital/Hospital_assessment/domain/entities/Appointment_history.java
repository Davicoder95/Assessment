package com.hospital.Hospital_assessment.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@Table(name = "Appointment_History")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment_history {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @OneToMany
    @JoinColumn(name = "id_history")
    private List<Appointment> appointments;

    private String observations;
}
