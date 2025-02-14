package io.dapsimni.rarity.domain.mysql.service;

import io.dapsimni.rarity.domain.mysql.domain.Rare;
import io.dapsimni.rarity.domain.mysql.repository.RareRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class RareService {
    private final RareRepository rareRepository;

    public void addRare(Rare rare) {
        rareRepository.save(rare);
    }

    public Optional<Rare> getRare(String rareId) {
        return rareRepository.findByRareId(rareId);
    }
}
