package com.hospital.Hospital_assessment.application.services.impl;



import com.hospital.Hospital_assessment.application.dtos.request.AppointmentRequest;
import com.hospital.Hospital_assessment.application.dtos.responses.AppointmentResponse;
import com.hospital.Hospital_assessment.application.mappers.AppointmentMapper;
import com.hospital.Hospital_assessment.domain.entities.*;
import com.hospital.Hospital_assessment.domain.enums.StatusDates;
import com.hospital.Hospital_assessment.domain.ports.service.IAppointmentService;
import com.hospital.Hospital_assessment.domain.ports.service.IDoctorService;
import com.hospital.Hospital_assessment.domain.ports.service.IPatientService;
import com.hospital.Hospital_assessment.domain.ports.service.IUserService;
import com.hospital.Hospital_assessment.infrastructure.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AppointmentService implements IAppointmentService {


    @Autowired
    private final AppointmentRepository appointmentRepository;
    @Autowired
    private final DoctorRepository doctorRepository;
    @Autowired
    private final PatientRepository patientRepository;
    @Autowired
    private final AppointmentMapper appointmentMapper;
    @Autowired
    private final AvailabilityRepository availabilityRepository;


    @Override
    public AppointmentResponse registerAppointment(AppointmentRequest appointmentRequest) {
        // Validar si el doctor existe
        Doctor doctor = doctorRepository.findById(appointmentRequest.getDoctorId())
                .orElseThrow(() -> new RuntimeException("Doctor no encontrado"));

        // Validar si el paciente existe
        Patient patient = patientRepository.findById(appointmentRequest.getPatientId())
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        // Convertir las cadenas de tiempo a LocalTime
        LocalTime startTime = LocalTime.parse(appointmentRequest.getStartTime());
        LocalTime endTime = LocalTime.parse(appointmentRequest.getEndTime());

        // Verificar si el doctor está disponible
        if (!isDoctorAvailable(doctor.getId(), appointmentRequest.getDate(), startTime, endTime)) {
            throw new RuntimeException("El doctor no está disponible en esta fecha y hora");
        }

        // Crear la cita utilizando el mapper
        Appointment appointment = appointmentMapper.toEntity(appointmentRequest, doctor, patient);

        // Consultar la disponibilidad del doctor para la fecha y la hora de la cita
        Availability availability = availabilityRepository.findFirstByDoctorIdAndDateAndStartTimeLessThanEqualAndEndTimeGreaterThanEqual(
                appointmentRequest.getDoctorId(),
                appointmentRequest.getDate(),
                startTime,
                endTime
        ).orElseThrow(() -> new RuntimeException("Disponibilidad no encontrada"));

        // Asignar la disponibilidad a la cita
        appointment.setAvailability(availability);

        // Establecer estado predeterminado
        appointment.setStatus(StatusDates.Pending);

        // Guardar la cita
        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Devolver la respuesta
        return appointmentMapper.toResponse(savedAppointment);
    }


    public boolean isDoctorAvailable(Long doctorId, LocalDate date, LocalTime startTime, LocalTime endTime) {
        // Imprimir los valores para verificar si todo es correcto
        System.out.println("Doctor ID: " + doctorId);
        System.out.println("Fecha: " + date);
        System.out.println("Hora de inicio: " + startTime);
        System.out.println("Hora de fin: " + endTime);

        // Consultar disponibilidad: Se verifica si el doctor tiene disponibilidad para el rango de tiempo solicitado
        return availabilityRepository.existsByDoctorIdAndDateAndStartTimeBeforeAndEndTimeAfter(
                doctorId, date, endTime, startTime
        );
    }




    @Override
    public List<AppointmentResponse> getAllAppointments() {
        List<Appointment> appointments = appointmentRepository.findAll();
        return appointments.stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByPatient(Long patientId) {
        List<Appointment> appointments = appointmentRepository.findByPatientId(patientId);
        return appointments.stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<AppointmentResponse> getAppointmentsByDoctor(Long doctorId) {
        List<Appointment> appointments = appointmentRepository.findByDoctorId(doctorId);
        return appointments.stream()
                .map(appointmentMapper::toResponse)
                .collect(Collectors.toList());
    }
}

