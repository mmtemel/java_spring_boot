package com.javaegitimleri.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

// @XmlRootElement
public class Owner {
    private long id;
    private String firstName;
    private String lastName;

    private Set<Pet> pets = new HashSet<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // @XmlTransient
    @JsonIgnore
    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
