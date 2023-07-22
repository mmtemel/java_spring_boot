package com.javaegitimleri.petclinic.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="t_pet")
public class Pet {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="petClinicSeqGen")
    @SequenceGenerator(name="petClinicSeqGen",sequenceName="petclinic_sequence", allocationSize=1)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="birth_date")
    private Date birthDate;

    @ManyToOne
    @JoinColumn(name="owner_id")
    private Owner owner;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet [id=" + id + ", name=" + name + ", birthDate=" + birthDate + ", owner=" + owner + "]";
    }
    
}
