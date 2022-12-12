package com.proyecto.clinica.repository;

import com.proyecto.clinica.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {

    @Query("FROM Dentists d WHERE d.name = ?1 AND d.surname = ?2")
    Dentist searchDentist(String name, String surname);


}
