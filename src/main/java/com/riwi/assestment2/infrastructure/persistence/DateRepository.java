package com.riwi.assestment2.infrastructure.persistence;

import com.riwi.assestment2.domain.entities.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface DateRepository extends JpaRepository<Date, Long> {
    List<Date> findByDoctorId_DateId(Long doctorId, LocalDate date);

}
