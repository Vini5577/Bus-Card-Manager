package com.api.busCardManager.repositories;

import com.api.busCardManager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
