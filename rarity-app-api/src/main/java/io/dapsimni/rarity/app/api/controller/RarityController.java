package io.dapsimni.rarity.app.api.controller;

import io.dapsimni.rarity.app.api.service.RarityService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RarityController {
    private final RarityService rarityService;

}
