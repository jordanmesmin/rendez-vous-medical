package com.fojomes.rendezvousmedical.service;
import com.fojomes.rendezvousmedical.entity.Medecin;
import com.fojomes.rendezvousmedical.entity.Creneau;
import com.fojomes.rendezvousmedical.repository.CreneauRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class CreneauServiceTest {

    @Mock
    private CreneauRepository creneauRepository;
    @InjectMocks
    public CreneauService creneauService;

    @Test
      void creerCreneau_valide_enregistreLeCreneau(){
        Medecin medecin = new Medecin();
        Creneau creneau = new Creneau();
        creneau.setMedecin(medecin);
        creneau.setDebut(LocalDateTime.now().plusDays(1));
        creneau.setFin(LocalDateTime.now().plusDays(1).plusMinutes(30));

        Creneau resultat = creneauService.creerCreneau(creneau);
        assertNotNull(resultat);
        verify(creneauRepository).save(creneau);
    }
}
