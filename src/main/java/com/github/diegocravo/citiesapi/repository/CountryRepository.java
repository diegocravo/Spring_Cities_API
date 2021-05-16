package com.github.diegocravo.citiesapi.repository;

import com.github.diegocravo.citiesapi.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
