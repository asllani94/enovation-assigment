package com.enovation.assigment.controller;

import com.enovation.assigment.model.Doctor;
import com.enovation.assigment.model.Staff;
import com.enovation.assigment.repository.DoctorRepository;
import com.enovation.assigment.repository.NurseRepository;
import com.enovation.assigment.repository.StaffRepository;
import com.enovation.assigment.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class StaffController {

    @Autowired
    DoctorRepository doctorsRepository;

    @Autowired
    NurseRepository nurseRepository;

    @Autowired
    WardRepository wardRepository;

    @GetMapping("/doctors")
    public ResponseEntity<List<Staff>> getAllAddresses() {
        List<Staff> doctors = new ArrayList<>();
        Iterable<Doctor> result = doctorsRepository.findAll();
        result.forEach(doctors::add);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping({"/doctors/{doctorId}"})
    public ResponseEntity<Staff> getDoctor(@PathVariable Long doctorId) {
        Optional<Doctor> staff = doctorsRepository.findById(doctorId);
        if( staff.isPresent()) {
            return new ResponseEntity<>(staff.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/doctors")
    public ResponseEntity<Staff> saveDoctor(@Valid @RequestBody Doctor doctor) {
        Doctor createdDoctor = doctorsRepository.save(doctor);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("doctor", "/doctor/" + createdDoctor.getId().toString());
        return new ResponseEntity<>(createdDoctor, httpHeaders, HttpStatus.CREATED);
    }
}
