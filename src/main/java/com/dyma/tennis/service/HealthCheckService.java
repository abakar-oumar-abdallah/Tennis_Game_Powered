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
On trouve dans cette couche toute la logique métier de notre application, c'est-à-dire toutes les règles et les processus
qui représentent ce que l'application fait et comment elle le fait.

Cette intelligence est la plupart du temps décrite par les experts métier et retranscrite dans le code par les développeurs.

Explications :

Le package com.dyma.tennis.service refléte le découpage en couches de notre application.

L'annotation @Service indique qu'il s'agit d'une classe qui s'occupe de logiques métiers, elle va aussi permettre de rendre
cette classe injectable (nous verrons comment) afin de pouvoir l'utiliser ailleurs. Sans cette annotation, HealthCheckService n'est qu'une classe Java comme une autre.

La logique qui était au départ dans notre couche présentation se trouve désormais au bon endroit, dans la couche métier.


 */