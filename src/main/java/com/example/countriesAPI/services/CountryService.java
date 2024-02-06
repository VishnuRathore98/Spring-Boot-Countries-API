package com.example.countriesAPI.services;

import com.example.countriesAPI.beans.Country;
import com.example.countriesAPI.controllers.AddResponse;
import com.example.countriesAPI.repositories.CountryRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
//@Service
public class CountryService {

    @Autowired
    CountryRepository countryRepository;

    //  This will return all the countries in a list.
    public List<Country> getAllCountries(){
//      Getting values of all the database objects and returning them into a list.
        return countryRepository.findAll();
    }

    //  This will return a country based on its Id.
//  As country Id and database value's index matches we can get the country based on the database's
//  index values.
    public Country getCountryById(int id){
        return countryRepository.findById(id).get();
    }

    //  This will search for the country by its name in the country map.
    public Country getCountryByName(String countryName){

        List<Country> countries = countryRepository.findAll();

//      If country by name is not found it will return null.
        Country country = null;

//      Searching for the country in the db, iterating over the key set.
        for(Country con:countries)
        {
//          If country is found assign it to the country variable.
            if (con.getCountryName().equalsIgnoreCase(countryName))
            {
                country = con;
                break;
            }
        }
//      Return the result.
        return country;
    }

    //  This will add a new country with a new country id.
    public Country addCountry(Country country){
//      Get the new id.
        country.setId(getMaxId());
//      Put both new id and country data into map object.
        countryRepository.save(country);
        return country;
    }

    //  This will generate a new id everytime a new country is being added to the country list.
    public int getMaxId(){
//      Check for all the available records and generate a new id based on db total size+1.
        return countryRepository.findAll().size() + 1;
    }

    //  This will update the existing country.
    public Country updateCountry(Country country){
//      To check if the provided country id is valid or not.
        if(country.getId()>0)
//          Overwrite the existing country data.
            countryRepository.save(country);
        return country;
    }

    //  This will delete the country with the provided id.
    public AddResponse deleteCountry(int id){
//      Remove the entry corresponding to the provided id.
        countryRepository.deleteById(id);
        AddResponse response = new AddResponse();
//      Set response data into the response class.
        response.setMessage("Country have been deleted...");
        response.setId(id);
        return response;
    }
}