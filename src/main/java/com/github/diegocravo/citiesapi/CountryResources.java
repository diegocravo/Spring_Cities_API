package com.github.diegocravo.citiesapi;

import java.util.Optional;

import com.github.diegocravo.citiesapi.countries.Country;
import com.github.diegocravo.citiesapi.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryResources {

    @Autowired
    private CountryRepository repository;

    @GetMapping
    public Page<Country> countries(Pageable page){
        return repository.findAll((org.springframework.data.domain.Pageable) page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Country> getOne(@PathVariable Long id){
        Optional<Country> optional = repository.findById(id);

        if(optional.isPresent()){
            return ResponseEntity.ok().body(optional.get());
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
