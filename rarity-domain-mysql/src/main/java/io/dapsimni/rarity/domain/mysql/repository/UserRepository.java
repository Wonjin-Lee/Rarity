package io.dapsimni.rarity.domain.mysql.repository;

import io.dapsimni.rarity.domain.mysql.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
