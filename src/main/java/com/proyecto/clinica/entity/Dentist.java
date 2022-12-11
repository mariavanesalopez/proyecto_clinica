package com.proyecto.clinica.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name = "Dentists")
public class Dentist {

    //propiedades
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String tuition;

    @OneToMany(mappedBy = "dentist")
    @JsonIgnore
    private Set<Turn> turns;


    //constructor
    public Dentist() {
    }

    public Dentist(String name, String surname, String tuition) {
        this.name = name;
        this.surname = surname;
        this.tuition = tuition;
    }

    public Dentist(Long id, String name, String surname, String tuition) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.tuition = tuition;
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

    public String getTuition() {
        return tuition;
    }

    public void setTuition(String tuition) {
        this.tuition = tuition;
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", tuition='" + tuition + '\'' +
                '}';
    }

    public Set<Turn> getTurns() {
        return turns;
    }

    public void setTurns(Set<Turn> turns) {
        this.turns = turns;
    }

    public boolean tuitionValid() {
        return this.tuition.length() == 4;
    }

}
