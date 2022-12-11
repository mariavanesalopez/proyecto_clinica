package com.proyecto.clinica.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "Turns")
public class Turn {
    //propiedades
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "dentist_id", nullable = false)
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "patient_id", nullable = false)
    private Patient patient;
    private LocalDateTime dateTime;


    //constructor
    public Turn() {
    }


    //metodos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Turn{" +
                "id=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                ", dateTime=" + dateTime +
                '}';
    }
}
