package com.example.countriesAPI.controllers;

import com.example.countriesAPI.beans.Country;
import com.example.countriesAPI.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CountryController {

//    CountryService countryService = new CountryService();
    @Autowired
    CountryService countryService;

    @GetMapping("/getcountries")
    public List getCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/getcountries/{id}")
    public Country getCountryById(@PathVariable(value = "id") int id){
        return countryService.getCountryById(id);
    }

    @GetMapping("/getcountries/countryname")
    public Country getCountryByName(@RequestParam(value = "name")String countryName){
        return countryService.getCountryByName(countryName);
    }

    @PostMapping("/addcountry")
    public Country addCountry(@RequestBody Country country){
        return countryService.addCountry(country);
    }

    @PutMapping("/updatecountry")
    public Country updateCountry(@RequestBody Country country){
        return countryService.updateCountry(country);
    }

    @DeleteMapping("/deletecountry/{id}")
    public AddResponse deleteCountry(@PathVariable(value = "id")int id){
        return countryService.deleteCountry(id);
    }
}
