package com.hospital.Hospital_assessment.domain.entities;


import com.hospital.Hospital_assessment.domain.enums.StatusDates;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "Appointment")
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime ;
    private StatusDates status=StatusDates.Pending;
    private String comments;

    @ManyToOne
    @JoinColumn(name = "id_doctor")
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "id_patient")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @JoinColumn(name = "availability_id")
    private Availability availability;

}
