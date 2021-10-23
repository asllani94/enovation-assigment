package com.enovation.assigment.controller;

import com.enovation.assigment.exception.RestException;
import com.enovation.assigment.model.Doctor;
import com.enovation.assigment.model.Nurse;
import com.enovation.assigment.model.Staff;
import com.enovation.assigment.model.WardClerk;
import com.enovation.assigment.service.StaffService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class StaffController {

    final
    StaffService staffService;

    public StaffController(StaffService staffService) {
        this.staffService = staffService;
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Staff>> getAllDoctors() {
        return new ResponseEntity<>(staffService.getAllDoctors(), HttpStatus.OK);
    }

    @GetMapping({"/doctors/{staffId}"})
    public ResponseEntity<Staff> getDoctor(@PathVariable Long staffId) throws RestException {
        return new ResponseEntity<>(staffService.getDoctor(staffId), HttpStatus.OK);
    }

    @PostMapping("/doctors")
    public ResponseEntity<Staff> saveDoctor(@Valid @RequestBody Doctor doctor) {
        return new ResponseEntity<>(staffService.createDoctor(doctor), HttpStatus.CREATED);
    }

    @PutMapping({"/doctors/{staffId}"})
    public ResponseEntity<Staff> updateDoctor(@PathVariable("staffId") Long staffId, @Valid @RequestBody Doctor doctor) throws RestException {
        return new ResponseEntity<>(staffService.updateDoctor(staffId, doctor), HttpStatus.OK);
    }

    @DeleteMapping({"/doctors/{staffId}"})
    public ResponseEntity<Staff> deleteDoctor(@PathVariable("staffId") Long staffId) throws RestException {
        staffService.deleteDoctor(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/nurses")
    public ResponseEntity<List<Staff>> getAllNurses() {
        return new ResponseEntity<>(staffService.getAllNurses(), HttpStatus.OK);
    }

    @GetMapping({"/nurses/{staffId}"})
    public ResponseEntity<Staff> getNurse(@PathVariable Long staffId) throws RestException {
        return new ResponseEntity<>(staffService.getNurse(staffId), HttpStatus.OK);
    }

    @PostMapping("/nurses")
    public ResponseEntity<Staff> saveNurse(@Valid @RequestBody Nurse nurse) {
        return new ResponseEntity<>(staffService.createNurse(nurse), HttpStatus.CREATED);
    }

    @PutMapping({"/nurses/{staffId}"})
    public ResponseEntity<Staff> updateNurse(@PathVariable("staffId") Long staffId, @Valid @RequestBody Nurse nurse) throws RestException {
        return new ResponseEntity<>(staffService.updateNurse(staffId, nurse), HttpStatus.OK);
    }

    @DeleteMapping({"/nurses/{staffId}"})
    public ResponseEntity<Staff> deleteNurse(@PathVariable("staffId") Long staffId) throws RestException {
        staffService.deleteNurse(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @GetMapping("/wards")
    public ResponseEntity<List<Staff>> getAllWardClerks() {
        return new ResponseEntity<>(staffService.getAllWardClerks(), HttpStatus.OK);
    }

    @GetMapping({"/wards/{staffId}"})
    public ResponseEntity<Staff> getWardClerk(@PathVariable Long staffId) throws RestException {
        return new ResponseEntity<>(staffService.getWardClerk(staffId), HttpStatus.OK);
    }

    @PostMapping("/wards")
    public ResponseEntity<Staff> saveWardClerk(@Valid @RequestBody WardClerk wardClerk) {
        return new ResponseEntity<>(staffService.createWardClerk(wardClerk), HttpStatus.CREATED);
    }

    @PutMapping({"/wards/{staffId}"})
    public ResponseEntity<Staff> updateWardClerk(@PathVariable("staffId") Long staffId, @Valid @RequestBody WardClerk wardClerk) throws RestException {
        return new ResponseEntity<>(staffService.updateWardClerk(staffId, wardClerk), HttpStatus.OK);
    }

    @DeleteMapping({"/wards/{staffId}"})
    public ResponseEntity<Staff> deleteWardClerk(@PathVariable("staffId") Long staffId) throws RestException {
        staffService.deleteWardClerk(staffId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
