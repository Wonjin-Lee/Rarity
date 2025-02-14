package io.dapsimni;

import io.dapsimni.rarity.domain.mysql.service.SampleService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Main {

    private final SampleService sampleService;

    public void api() {
        sampleService.sample();
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}