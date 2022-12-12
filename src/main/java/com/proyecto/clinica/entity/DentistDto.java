package com.proyecto.clinica.entity;

public class DentistDto {
    private Long id;
    private String name;
    private String surname;

    public DentistDto() {
    }

    public Long getId() {
        return id;
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
}
