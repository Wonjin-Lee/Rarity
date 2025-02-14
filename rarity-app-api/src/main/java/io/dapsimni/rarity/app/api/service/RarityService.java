package io.dapsimni.rarity.app.api.service;

import io.dapsimni.rarity.domain.mysql.domain.Rare;
import io.dapsimni.rarity.domain.mysql.service.RareService;
import io.dapsimni.rarity.domain.redis.service.RedisService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@RequiredArgsConstructor
@Service
public class RarityService {
    private final RareService rareService;
    private final RedisService redisService;

    public void createRare(Rare rare) {
        redisService.setValue(
                "rare:" + rare.getRareId() + ":quantity",
                String.valueOf(rare.getQuantity()),
                1,
                TimeUnit.DAYS
        );
    }

    public boolean participate(String rareId, String userId) {
        int quantity = Integer.parseInt(redisService.getValue("rare:" + rareId + ":quantity"));

        Long currentCount = redisService.increment("rare:" + rareId + ":count");

        if (currentCount > quantity) {
            redisService.decrement("rare:" + rareId + ":count");
            return false;
        }

        return true;
    }
}
