package com.enovation.assigment.repository;
import com.enovation.assigment.model.Staff;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StaffRepository extends CrudRepository<Staff, Long> {

}