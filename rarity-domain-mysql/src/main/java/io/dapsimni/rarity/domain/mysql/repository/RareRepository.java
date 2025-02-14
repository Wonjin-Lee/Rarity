package io.dapsimni.rarity.domain.mysql.repository;

import io.dapsimni.rarity.domain.mysql.domain.Rare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RareRepository extends JpaRepository<Rare, Long> {
}
