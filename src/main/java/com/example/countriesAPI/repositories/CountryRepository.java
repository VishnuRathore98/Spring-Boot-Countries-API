package com.example.countriesAPI.repositories;

import com.example.countriesAPI.beans.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
