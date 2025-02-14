package io.dapsimni.rarity.app.api.service;

import io.dapsimni.rarity.domain.mysql.domain.Rare;
import io.dapsimni.rarity.domain.mysql.service.RareService;
import io.dapsimni.rarity.domain.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class RarityService {
    private final RareService rareService;
    private final RedisService redisService;

    @Transactional
    public void createRare(Rare rare) {
        rareService.addRare(rare);
        redisService.setValue(
                "rare:" + rare.getRareId() + ":quantity",
                String.valueOf(rare.getQuantity()),
                1,
                TimeUnit.DAYS
        );
    }

    public boolean hasQuantity(String rareId) {
        int quantity = Integer.parseInt(redisService.getValue("rare:" + rareId + ":quantity"));

        Long currentCount = redisService.increment("rare:" + rareId + ":count");

        if (currentCount > quantity) {
            redisService.decrement("rare:" + rareId + ":count");
            return false;
        }

        return true;
    }

    public void participate(String rareId, String userId) {
        if (hasQuantity(rareId)) {
            // TODO Kafka 연동
        }
    }
}
