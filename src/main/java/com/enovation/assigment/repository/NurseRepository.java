package com.enovation.assigment.repository;
import com.enovation.assigment.model.Nurse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NurseRepository extends CrudRepository<Nurse, Long> {
}