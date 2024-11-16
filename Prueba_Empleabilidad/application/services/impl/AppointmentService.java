package com.assessment.Prueba_Empleabilidad.application.services.impl;


import com.assessment.Prueba_Empleabilidad.application.dtos.request.AppointmentRequest;
import com.assessment.Prueba_Empleabilidad.application.dtos.responses.AppointmentResponse;
import com.assessment.Prueba_Empleabilidad.application.mappers.AppointmentMapper;
import com.assessment.Prueba_Empleabilidad.domain.entities.Appointment;
import com.assessment.Prueba_Empleabilidad.domain.entities.Doctor;
import com.assessment.Prueba_Empleabilidad.domain.entities.Patient;
import com.assessment.Prueba_Empleabilidad.domain.entities.User;
import com.assessment.Prueba_Empleabilidad.domain.enums.StatusDates;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IAppointmentService;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IDoctorService;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IPatientService;
import com.assessment.Prueba_Empleabilidad.domain.ports.service.IUserService;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.AppointmentRepository;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.DoctorRepository;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.PatientRepository;
import com.assessment.Prueba_Empleabilidad.infrastructure.persistence.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
    private final UserRepository userRepository;
    @Autowired
    private final AppointmentMapper appointmentMapper;
    @Autowired
    private final IDoctorService doctorService;
    @Autowired
    private final IPatientService patientService;
    @Autowired
    private final IUserService userService;


    @Override
    public AppointmentResponse registerAppointment(AppointmentRequest appointmentRequest) {
        // Validar si el doctor existe
        Optional<Doctor> doctorOpt = doctorRepository.findById(appointmentRequest.getDoctorId());
        if (doctorOpt.isEmpty()) {
            throw new RuntimeException("Doctor no encontrado");
        }
        Doctor doctor = doctorOpt.get();

        // Validar si el paciente existe
        Optional<Patient> patientOpt = patientRepository.findById(appointmentRequest.getPatientId());
        if (patientOpt.isEmpty()) {
            throw new RuntimeException("Paciente no encontrado");
        }
        Patient patient = patientOpt.get();

        // Validar si el usuario existe (quien está registrando la cita)
        Optional<User> userOpt = userRepository.findById(appointmentRequest.getPatientId());
        if (userOpt.isEmpty()) {
            throw new RuntimeException("Usuario no encontrado");
        }
        User user = userOpt.get();

        // Verificar si el doctor está disponible en la fecha y hora
        if (!isDoctorAvailable(doctor, appointmentRequest.getDateTime())) {
            throw new RuntimeException("El doctor no está disponible en esta fecha y hora");
        }

        // Verificar citas duplicadas para el doctor en la misma hora
        Optional<Appointment> existingAppointmentForDoctor = appointmentRepository.findByDoctorAndDateTime(doctor, appointmentRequest.getDateTime());
        if (existingAppointmentForDoctor.isPresent()) {
            throw new RuntimeException("Ya existe una cita para el doctor en esa hora");
        }

        // Verificar citas duplicadas para el paciente en la misma hora
        Optional<Appointment> existingAppointmentForPatient = appointmentRepository.findByPatientAndDateTime(patient, appointmentRequest.getDateTime());
        if (existingAppointmentForPatient.isPresent()) {
            throw new RuntimeException("Ya existe una cita para el paciente en esa hora");
        }

        // Crear y registrar la cita
        Appointment appointment = appointmentMapper.toEntity(appointmentRequest, doctor, patient, user);
        appointment.setStatus(StatusDates.Pending); // Estado predeterminado para la cita

        // Guardar la cita en la base de datos
        Appointment savedAppointment = appointmentRepository.save(appointment);

        // Devolver la respuesta mapeada
        return appointmentMapper.toResponse(savedAppointment);
    }

    private boolean isDoctorAvailable(Doctor doctor, LocalDateTime appointmentTime) {
        // Verificar si el doctor tiene disponibilidad en la fecha y hora solicitada
        return doctor.getAvailabilities().stream()
                .anyMatch(availability -> availability.getDate().equals(appointmentTime.toLocalDate()) &&
                        availability.getStartTime().equals(appointmentTime.toLocalTime()));
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

