package com.riwi.assestment2.infrastructure.persistence;

import com.riwi.assestment2.domain.entities.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface DateRepository extends JpaRepository<Date, Long> {
    List<Date> findByDoctorIdAndAppointmentDate(Long doctorId, LocalDateTime appointmentDate);
}
