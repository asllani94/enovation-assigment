package com.enovation.assigment.repository;
import com.enovation.assigment.model.WardClerk;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardClerkRepository extends CrudRepository<WardClerk, Long> {
}