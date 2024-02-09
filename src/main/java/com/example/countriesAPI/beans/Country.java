package com.example.countriesAPI.beans;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "country_name")
    private String countryName;

    @Column(name = "capital")
    private String countryCapital;
    Country(){}
    public Country(int id, String countryCapital, String countryName) {
        this.id = id;
        this.countryCapital = countryCapital;
        this.countryName = countryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital) {
        this.countryCapital = countryCapital;
    }

}
