package io.dapsimni.rarity.domain.mysql.repository;

import io.dapsimni.rarity.domain.mysql.domain.Rare;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RareRepository extends JpaRepository<Rare, Long> {
    Optional<Rare> findByRareId(String rareId);
}
