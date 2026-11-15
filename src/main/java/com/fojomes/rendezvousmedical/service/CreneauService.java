package com.fojomes.rendezvousmedical.service;

import com.fojomes.rendezvousmedical.entity.Creneau;
import com.fojomes.rendezvousmedical.repository.CreneauRepository;

public class CreneauService {

    private final CreneauRepository creneauRepository;

    public CreneauService(CreneauRepository creneauRepository) {
        this.creneauRepository = creneauRepository;
    }

    public Creneau creerCreneau(Creneau creneau) {
        creneauRepository.save(creneau);
        return creneau;
    }
}