package com.enovation.assigment.repository;
import com.enovation.assigment.model.Ward;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WardRepository extends CrudRepository<Ward, Long> {
}