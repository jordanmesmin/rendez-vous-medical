package com.fojomes.rendezvousmedical.service;

import com.fojomes.rendezvousmedical.entity.Creneau;
import com.fojomes.rendezvousmedical.repository.CreneauRepository;

import java.time.LocalDateTime;

public class CreneauService {

    private final CreneauRepository creneauRepository;

    public CreneauService(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }

    public Creneau creerCreneau(Creneau creneau) {
        if (creneau.getDebut().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Le creneau ne peut pas commencer dans le passe");
        }
        creneauRepository.save(creneau);
        return creneau;
    }


}