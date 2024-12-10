package com.riwi.assestment2.domain.entities;

import com.riwi.assestment2.domain.enums.StatusDates;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class Date {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;

    private LocalDateTime Date;

    private StatusDates status;
}

