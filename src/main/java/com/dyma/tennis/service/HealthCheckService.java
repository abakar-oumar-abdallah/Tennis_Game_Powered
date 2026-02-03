package com.dyma.tennis.service;

import com.dyma.tennis.ApplicationStatus;
import com.dyma.tennis.HealthCheck;
import org.springframework.stereotype.Service;

@Service
public class HealthCheckService {
    public HealthCheck healthcheck() {
        return new HealthCheck(ApplicationStatus.OK, "Welcome to Koukaye Tennis");
    }
}


/*
La couche service :

Nous continuons à évoluer dans les couches de notre application, on s'intéresse cette fois-ci à la couche service, que l'on appelle aussi la couche métier.
 */