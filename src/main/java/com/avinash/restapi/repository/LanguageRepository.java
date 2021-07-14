package com.avinash.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.avinash.restapi.model.Language;

public interface LanguageRepository extends JpaRepository<Language, Long> {

}
