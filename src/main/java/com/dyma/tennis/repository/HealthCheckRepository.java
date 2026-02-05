package com.dyma.tennis.repository;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class HealthCheckRepository {

    @Autowired
    private EntityManager entityManager;

    public Long countApplicationConnections() {
        String applicationConnectionsQuery = "select count(*) from pg_stat_activity where application_name = 'PostgreSQL JDBC Driver'";
        return (Long) entityManager.createNativeQuery(applicationConnectionsQuery).getSingleResult();
    }

}

/*
Un premier repository : HealthCheck :

Pour continuer sur notre service donnant l'état de santé de notre application, nous allons mettre en place un repository
qui aura pour rôle d'aller interroger la base de données, via une requête arbitraire, et ainsi s'assurer que notre application est techniquement opérationnelle.

En effet, avec la mise en place de ce repository, lorsque l'utilisateur va contacter le contrôleur REST HealthCheck,
toutes les couches de notre application vont être traversées, ainsi, on peut remonter un statut OK si la base de données est opérationnelle ou KO dans le cas contraire.

Quelques explications sur ce code.

L'annotation @Repository indique que cette classe a pour rôle d'accéder à des données, en lui injectant le composant EntityManager,
on peut déclencher une requête native, c'est-à-dire en pur SQL, cette requête peut d'ailleurs être exécutée directement dans le client pgAdmin.

Alors... Nous venons de voir que l'un des intérêts de la couche de persistance est de bénéficier d'un mécanisme de mapping objet — relationnel
pour justement s'affranchir des spécificités d'une base de données en particulier.

C'est exact, mais dans cet exemple, nous exécutons une requête sur une "vu système" qui stocke des informations sur les sessions actives sur la base de données,
c'est spécifique à PostgreSQL, nous devons donc exécuter ce qu'on appelle une requête "native", en SQL pur.

La requête exécutée ici permet de compter le nombre de connexions que compte le pool de notre application.
 */