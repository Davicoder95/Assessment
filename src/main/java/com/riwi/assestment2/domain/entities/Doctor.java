package com.riwi.assestment2.domain.entities;

import com.riwi.assestment2.domain.enums.StatusMedic;
import jakarta.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity(name = "doctors")
@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    private User user;

    private String specialty;
    @Enumerated(EnumType.STRING)
    private StatusMedic status;
}