package com.enovation.assigment.service;

import com.enovation.assigment.exception.RestException;
import com.enovation.assigment.model.Doctor;
import com.enovation.assigment.model.Nurse;
import com.enovation.assigment.model.Staff;
import com.enovation.assigment.model.WardClerk;
import com.enovation.assigment.repository.DoctorRepository;
import com.enovation.assigment.repository.NurseRepository;
import com.enovation.assigment.repository.WardClerkRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StaffService {

    private final DoctorRepository doctorRepository;

    private final NurseRepository nurseRepository;

    private final WardClerkRepository wardClerkRepository;

    public StaffService(DoctorRepository doctorRepository, NurseRepository nurseRepository, WardClerkRepository wardClerkRepository) {

        this.doctorRepository = doctorRepository;
        this.nurseRepository = nurseRepository;
        this.wardClerkRepository = wardClerkRepository;
    }

    public List<Doctor> getAllDoctors() {
        List<Doctor> doctorList = new ArrayList<>();
        Iterable<Doctor> doctors = doctorRepository.findAll();
        doctors.forEach(doctorList::add);
        return doctorList;
    }

    public Doctor getDoctor(Long staffId) throws RestException {
        return doctorRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Doctor not found", HttpStatus.NOT_FOUND));
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor updateDoctor(Long staffId, Doctor newDoctor) throws RestException {
        Doctor fromDb = doctorRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Doctor not found", HttpStatus.NOT_FOUND));
        updateStaff(fromDb, newDoctor);
        fromDb.setSpeciality(newDoctor.getSpeciality());
        fromDb.setNumberOfSurgeries(newDoctor.getNumberOfSurgeries());
        doctorRepository.save(fromDb);
        return fromDb;
    }

    public void deleteDoctor(Long staffId) throws RestException {
        Doctor doctor = doctorRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Doctor not found", HttpStatus.NOT_FOUND));
        doctorRepository.delete(doctor);
    }

    public List<Nurse> getAllNurses() {
        List<Nurse> list = new ArrayList<>();
        Iterable<Nurse> nurses = nurseRepository.findAll();
        nurses.forEach(list::add);
        return list;
    }

    public Nurse getNurse(Long staffId) throws RestException {
        return nurseRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Nurse not found", HttpStatus.NOT_FOUND));
    }

    public Nurse createNurse(Nurse nurse) {
        return nurseRepository.save(nurse);
    }

    public Nurse updateNurse(Long staffId, Nurse newNurse) throws RestException {
        Nurse fromDb = nurseRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Nurse not found", HttpStatus.NOT_FOUND));
        updateStaff(fromDb, newNurse);
        fromDb.setLicenseCode(newNurse.getLicenseCode());
        nurseRepository.save(fromDb);
        return fromDb;
    }

    public void deleteNurse(Long staffId) throws RestException {
        Nurse nurse = nurseRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Nurse not found", HttpStatus.NOT_FOUND));
        nurseRepository.delete(nurse);
    }

    public List<WardClerk> getAllWardClerks() {
        List<WardClerk> list = new ArrayList<>();
        Iterable<WardClerk> wards = wardClerkRepository.findAll();
        wards.forEach(list::add);
        return list;
    }

    public WardClerk getWardClerk(Long staffId) throws RestException {
        return wardClerkRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Ward clerk not found", HttpStatus.NOT_FOUND));
    }

    public WardClerk createWardClerk(WardClerk wardClerk) {
        return wardClerkRepository.save(wardClerk);
    }

    public WardClerk updateWardClerk(Long staffId, WardClerk newWardClerk) throws RestException {
        WardClerk fromDb = wardClerkRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Ward clerk not found", HttpStatus.NOT_FOUND));
        updateStaff(fromDb, newWardClerk);
        fromDb.setLocation(newWardClerk.getLocation());
        wardClerkRepository.save(fromDb);
        return fromDb;
    }

    public void deleteWardClerk(Long staffId) throws RestException {
        WardClerk wardClerk = wardClerkRepository.findById(staffId)
                .orElseThrow(() -> new RestException("Ward clerk not found", HttpStatus.NOT_FOUND));
        wardClerkRepository.delete(wardClerk);
    }


    private void updateStaff(Staff oldStaffData, Staff newStaffData) {
        oldStaffData.setFirstName(newStaffData.getFirstName());
        oldStaffData.setLastName(newStaffData.getLastName());
        oldStaffData.setEmail(newStaffData.getLastName());
        oldStaffData.setJoined(newStaffData.getJoined());
    }

}
