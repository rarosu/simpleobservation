package com.rarosu.simpleobservation.service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaxaController {
    @GetMapping(path = "/isAlive")
    public boolean isAlive() {
        return true;
    }
}
