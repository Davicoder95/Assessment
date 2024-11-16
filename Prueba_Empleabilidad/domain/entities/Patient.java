package com.assessment.Prueba_Empleabilidad.domain.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.List;

@Entity
@Data
@Table(name = "Patients")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String phone;
    private String birthdate;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> dates;

    @OneToOne(mappedBy = "patient")
    private Appointment_history appointmentHistory;
}
