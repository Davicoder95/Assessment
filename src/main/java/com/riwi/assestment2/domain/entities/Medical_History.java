package com.riwi.assestment2.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "medical_history")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Medical_History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    @OneToOne
    private Patient patient;

    private LocalDateTime Date;

    private String doctor_name;

    private String doctor_phone;

    private String patient_name;

    private String diagnosis;

    private String ReasonOfDate;
}
