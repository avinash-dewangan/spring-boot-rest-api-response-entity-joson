package com.avinash.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avinash.restapi.model.Gender;

@Repository
public interface GenderRepository extends JpaRepository<Gender, Long> {

}
