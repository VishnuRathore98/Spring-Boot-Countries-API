package com.example.countriesAPI.services;

import com.example.countriesAPI.beans.Country;
import com.example.countriesAPI.controllers.AddResponse;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class CountryService {

    static HashMap<Integer, Country> countryIdMap;

    public CountryService(){
        countryIdMap = new HashMap<>();

        Country indiaCountry = new Country(1,"India","Delhi");
        Country usaCountry = new Country(2, "USA", "Washington");
        Country englandCountry = new Country(3, "England", "London");

        countryIdMap.put(1, indiaCountry);
        countryIdMap.put(2, usaCountry);
        countryIdMap.put(3, englandCountry);
    }

//  This will return all the countries in a list.
    public List getAllCountries(){
//      Getting values of all the hashmap objects and storing them into a list.
        List countries = new ArrayList(countryIdMap.values());
        return countries;
    }

//  This will return a country based on its Id.
//  As country Id and hashmap values index matches we can get the country based on the hashmap's
//  index values.
    public Country getCountryById(int id){
        Country country = countryIdMap.get(id);
        return country;
    }

//  This will search for the country by its name in the country map.
    public Country getCountryByName(String countryName){
//      If country by name is not found it will return null.
        Country country = null;
//      Searching for the country in the map, iterating over the key set.
        for(int i:countryIdMap.keySet())
        {
//          If country is found assign it to the country variable.
            if (countryIdMap.get(i).getCountryName().equals(countryName))
                country = countryIdMap.get(i);
        }
//      Return the result.
        return country;
    }

//  This will add a new country with a new country id.
    public Country addCountry(Country country){
//      Get the new id.
        country.setId(getMaxId());
//      Put both new id and country data into map object.
        countryIdMap.put(country.getId(),country);
        return country;
    }

//  This will generate a new id everytime a new country is being added to the country list.
    public static int getMaxId(){
        int max = 0;
//      Check for the last available id and generate a new one just next to it.
        for(int i: countryIdMap.keySet())
            if (max<=i)
                max=i;
        return max+1;
    }

//  This will update the existing country.
    public Country updateCountry(Country country){
//      To check if the provided country id is valid or not.
        if(country.getId()>0)
//          Overwrite the existing country data.
            countryIdMap.put(country.getId(), country);
        return country;
    }

//  This will delete the country with the provided id.
    public AddResponse deleteCountry(int id){
//      Remove the entry corresponding to the provided id.
        countryIdMap.remove(id);
        AddResponse response = new AddResponse();
//      Set response data into the response class.
        response.setMessage("Country have been deleted...");
        response.setId(id);
        return response;
    }
}