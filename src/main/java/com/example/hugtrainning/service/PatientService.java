package com.example.hugtrainning.service;

import com.example.hugtrainning.entity.Patient;
import com.example.hugtrainning.exceptions.WebClientError.NotFoundException;
import com.example.hugtrainning.repository.PatientRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Patient Service
 * @author fkabouche
 */
@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    public Patient save(Patient patient) {
        this.patientRepository.findByEmail(patient.getEmail());
        return this.patientRepository.save(patient.withId(UUID.randomUUID().toString()));
    }

    public Iterable<Patient> findAll() {
        return this.patientRepository.findAll();
    }

    public Patient findById(String id) {
        return this.patientRepository.findById(id).orElseThrow( () -> new NotFoundException("Patient with id = " + id + " was not found."));
    }

    public Patient findByEmail(String email) {
        return this.patientRepository.findByEmail(email).orElseThrow( () -> new NotFoundException("Patient with email = " + email + " was not found."));
    }

    public Patient update(Patient patient) {
        this.deleteById(this.findByEmail(patient.getEmail()).getId());
        return this.save(patient);
    }

    public void deleteById(String id) {
        this.patientRepository.deleteById(id);
    }

}
