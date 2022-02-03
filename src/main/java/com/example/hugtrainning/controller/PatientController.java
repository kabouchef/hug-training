package com.example.hugtrainning.controller;

import com.example.hugtrainning.constant.RestConstants;
import com.example.hugtrainning.entity.Patient;
import com.example.hugtrainning.service.PatientService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * Patient Controller
 *
 * @author fkabouche
 */
@Data
@RestController(RestConstants.PATIENT_PATH)
@OpenAPIDefinition(info = @Info(title = "Patient Controller"))
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    /**
     * save
     * @param patient : patient
     * @return {@link Patient}
     */
    @Tag(name = "save", description = "Save a patient")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Patient save(@RequestBody Patient patient) {
        return this.patientService.save(patient);
    }

    /**
     * findAll
     * @return {@link Iterable<Patient>}
     */
    @Tag(name = "findAll", description = "Find all patients")
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Patient> findAll() {
        return this.patientService.findAll();
    }

    /**
     * findById
     *
     * @param id : id
     * @return {@link Patient}
     */
    @Tag(name = "findById", description = "Find By Id a patient")
    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Patient findById(@PathVariable String id) {
        return this.patientService.findById(id);
    }

    /**
     * findByEmail
     *
     * @param email : email
     * @return {@link Patient}
     */
    @Tag(name = "findByEmail", description = "Find By Email a patient")
    @GetMapping("email")
    @ResponseStatus(HttpStatus.OK)
    public Patient findByEmail(@RequestParam String email) {
        return this.patientService.findByEmail(email);
    }

    /**
     * update
     *
     * @param patient : patient
     * @return {@link Patient}
     */
    @Tag(name = "update", description = "Update a patient")
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Patient update(@RequestBody Patient patient) {
        return this.patientService.update(patient);
    }

    /**
     * deleteById
     *
     * @param id : id
     */
    @Tag(name = "deleteById", description = "Delete a patient")
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteById(String id) {
        this.patientService.deleteById(id);
    }
}
