package com.assessment.Prueba_Empleabilidad.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@Table(name = "Doctors")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String specialty;
    private String email;
    private String phone;
    private String startTime;
    private String endTime;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> dates;

    @OneToMany(mappedBy = "doctor")
    private List<Availability> availabilities;
}
