package com.proyecto.clinica.repository;

import com.proyecto.clinica.entity.Dentist;
import com.proyecto.clinica.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface IPatientRepository extends JpaRepository<Patient, Long> {

    @Query("FROM Patients p WHERE p.name = ?1 AND p.surname = ?2")
    Patient searchPatient(String name, String surname);

}
