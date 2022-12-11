package com.proyecto.clinica.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDate;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name= "Patients")
public class Patient {
    //propiedades
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private int dni;
    private String address;
    private LocalDate dateOfEntry;

    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Turn> turns;

   //constructor
    public Patient() {
    }

    public Patient(String name, String surname, int dni, String address, LocalDate dateOfEntry) {
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.address = address;
        this.dateOfEntry = dateOfEntry;
    }

    public Patient(Long id, String name, String surname, int dni, String address, LocalDate dateOfEntry) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dni = dni;
        this.address = address;
        this.dateOfEntry = dateOfEntry;
    }

    //metodos
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(LocalDate dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", dni=" + dni +
                ", address='" + address + '\'' +
                ", dateOfEntry=" + dateOfEntry +
                '}';
    }

    public boolean dniValid() {
        //varias personas conocidas tienen dni que inician con el numero cero.
        return this.dni >= 0;
    }

}
