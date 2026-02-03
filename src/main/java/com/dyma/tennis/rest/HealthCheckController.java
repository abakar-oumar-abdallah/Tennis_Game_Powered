package com.dyma.tennis.rest;

import com.dyma.tennis.ApplicationStatus;
import com.dyma.tennis.HealthCheck;
import com.dyma.tennis.service.HealthCheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckController {

    @Autowired
    private HealthCheckService healthCheckService;

    @GetMapping("/healthcheck")
    public HealthCheck healthcheck() {
        return healthCheckService.healthcheck();
    }

}

/*
Nous avons créé notre premier contrôleur REST. Pour rappel, la couche REST de notre application, c'est la couche de présentation,
celle qui permet d'interagir avec un utilisateur ou un autre système.

Ce contrôleur va avoir pour rôle de donner l'état de santé de notre application.

Quelques explications sur ce contrôleur :

Ce code est rangé dans le package com.dyma.tennis.rest car comme vu précédemment, notre application est organisée en couches.
Ici rest est notre couche de présentation.

L'annotation @RestController transforme notre classe Java HealthCheckController en un contrôleur REST capable de traiter des requêtes.
Sans cette annotation, HealthCheckController n'est qu'une classe Java comme une autre.

L'annotation @GetMapping permet de s'assurer que toute requête HTTP GET vers le chemin /healthcheck est redirigée et traitée par la méthode healthcheck().

L'objet HealthCheck modélise l'état de santé de l'application.

Pour le moment, ce contrôleur se contente simplement de retourner une réponse avec le statut OK et un message de bienvenue.

 */
