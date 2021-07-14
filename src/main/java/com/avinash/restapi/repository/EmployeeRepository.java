package com.avinash.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avinash.restapi.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
