package com.riwi.assestment2.infrastructure.persistence;

import com.riwi.assestment2.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String name);
}
