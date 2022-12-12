package com.proyecto.clinica.entity;

import java.time.LocalDateTime;

public class TurnDto {
    private Long id;
    private Dentist dentist;
    private Patient patient;
    private LocalDateTime dateTime;

    public TurnDto() {
    }

    public Long getId() {
        return id;
    }


    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
