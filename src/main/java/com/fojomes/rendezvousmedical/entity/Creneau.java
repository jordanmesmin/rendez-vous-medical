package com.fojomes.rendezvousmedical.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Creneau {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime debut;
    private LocalDateTime fin;

    @ManyToOne
    @JoinColumn(nullable = false)
    private Medecin medecin;


    public Creneau() {};

    public Long getId() {
        return id;
    }

    public LocalDateTime getDebut() {
        return debut;
    }

    public void setDebut(LocalDateTime debut) {
        this.debut = debut;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setFin(LocalDateTime fin) {
        this.fin = fin;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }
}
