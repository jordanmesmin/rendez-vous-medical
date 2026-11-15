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

import static java.time.LocalDate.now;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
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

        if (creneau.getDebut().isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("Le créneau ne peut pas commencer dans le passé");
        }

         creneau.setMedecin(medecin);
        creneau.setDebut(LocalDateTime.now().plusDays(1));
        creneau.setFin(LocalDateTime.now().plusDays(1).plusMinutes(30));

        Creneau resultat = creneauService.creerCreneau(creneau);
        assertNotNull(resultat);
        verify(creneauRepository).save(creneau);
    }

    @Test
    void creerCreneau_debutDansLePasse_lanceException() {
// Arrange
        Medecin medecin = new Medecin();
        Creneau creneau = new Creneau();
        creneau.setMedecin(medecin);
        creneau.setDebut(LocalDateTime.now().minusDays(1));
        creneau.setFin(LocalDateTime.now().minusDays(1).plusMinutes(30));

// Act + Assert
        assertThrows(IllegalArgumentException.class, () -> creneauService.creerCreneau(creneau));

// Assert
        verify(creneauRepository, never()).save(any());
    }
}
