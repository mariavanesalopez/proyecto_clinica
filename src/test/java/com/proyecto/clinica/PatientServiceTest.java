package com.proyecto.clinica;


import com.proyecto.clinica.entity.Patient;

import com.proyecto.clinica.service.IPatientService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;


@SpringBootTest
public class PatientServiceTest {
  /*  ------prueba inicial -----
  @Autowired
   private IPatientService patientService;

   @Test
   public void testCreatePatient() {

     PatientDto patientDto = new PatientDto();

      patientDto.setName("Carla");
      patientDto.setSurname("Flores");
      patientService.createPatient(patientDto);
      PatientDto patientDto6 = patientService.readPatient(6L);

      Assertions.assertTrue(patientDto6 !=null);
   }*/


      @Test
      public void DniIsPositive_ReturnTrue () {
         //GIVEN
         Patient patient2 = new Patient("luis", "saenz", 11345678, "laprida 200", LocalDate.now());

         //WHEN
         boolean response = patient2.dniValid();

         //THEN
         Assertions.assertTrue(response);
      }

      @Test
      public void dniIsNegative_ReturnFalse () {
         //GIVEN
         Patient patient3 = new Patient(3L, "mario", "paez", -1, "corrientes 100", LocalDate.now());

         //WHEN
         boolean response = patient3.dniValid();

         //THEN
         Assertions.assertFalse(response);
      }
   }


