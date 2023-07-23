package com.javaegitimleri.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="t_owner")
@XmlRootElement
public class Owner extends BaseEntity{
    
    @NotEmpty
    @Column(name="first_name")
    private String firstName;

    @NotEmpty(message = "empty lastname is not allowed")
    @Column(name="last_name")
    private String lastName;

    @OneToMany(mappedBy="owner")
    private Set<Pet> pets = new HashSet<>();

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

    @XmlTransient
    @JsonIgnore
    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Owner [id=" + getId() + ", firstName=" + firstName + ", lastName=" + lastName + "]";
    }
}
