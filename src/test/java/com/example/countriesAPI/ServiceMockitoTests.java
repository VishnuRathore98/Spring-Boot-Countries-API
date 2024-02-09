package com.example.countriesAPI;

import com.example.countriesAPI.beans.Country;
import com.example.countriesAPI.repositories.CountryRepository;
import com.example.countriesAPI.services.CountryService;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

// Defining a test class for service layer.
@SpringBootTest(classes = {ServiceMockitoTests.class})
public class ServiceMockitoTests {

//  Mocking CountryRepository class so that we can redirect the db output to mocked output.
    @Mock
    CountryRepository countryRepository;

//
    @InjectMocks
    CountryService countryService;

//  Testing getAllCountries() method with mocked response.
    @Test
    @Order(1)
    public void test_getAllCountries(){

//      Static mock data.
        List<Country> myCountries = new ArrayList<Country>();
        myCountries.add(new Country(1, "Islamabad", "Pakistan"));
        myCountries.add(new Country(2, "Beijing","China"));

//      Defining mock.
        when(countryRepository.findAll()).thenReturn(myCountries);

//      Let's check if our efforts are not in vain.
        System.out.println(countryService.getAllCountries().getFirst().getCountryName());
        System.out.println(countryService.getAllCountries().size());
    }
}
