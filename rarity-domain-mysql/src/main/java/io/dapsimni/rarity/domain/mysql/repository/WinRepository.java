package io.dapsimni.rarity.domain.mysql.repository;

import io.dapsimni.rarity.domain.mysql.domain.Win;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinRepository extends JpaRepository<Win, Long> {
}
