package com.javaegitimleri.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.petclinic.dao.OwnerRepository;
import com.javaegitimleri.petclinic.dao.PetRepository;
import com.javaegitimleri.petclinic.exception.OwnerNotFoundException;
import com.javaegitimleri.petclinic.model.Owner;

//service anotasyonu spring container'ın ilgili sınıftan bir tane
//bean oluşturmasını sağlayacak.
@Transactional
@Service
public class PetClinicServiceImpl implements PetClinicService{

    private OwnerRepository ownerRepository;

    private PetRepository petRepository;

    //autowired anotasyonu sayesinde spring container owner repository
    //tipindeki bir bean'i petclinic service bean'inin içerisine bu
    //bu setter metodu vasıtasiyle enjecte edecektir.
    @Autowired
    public void setOwnerRepository(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Autowired
    public void setPetRepository(PetRepository petRepository){
        this.petRepository = petRepository;
    }

    @Override
    public List<Owner> findOwners() {
        return ownerRepository.findAll();
    }

    @Override
    public List<Owner> findOwners(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public Owner findOwner(Long id) throws OwnerNotFoundException {
        Owner owner = ownerRepository.findById(id);
        if(owner == null)
            throw new OwnerNotFoundException("Owner not found with id: "+ id);
        return owner;
    }

    @Override
    public void createOwner(Owner owner) {
        ownerRepository.create(owner);
    }

    @Override
    public void update(Owner owner) {
        ownerRepository.update(owner);
    }

    @Override
    public void deleteOwner(Long id) {
        petRepository.delete(id);
        ownerRepository.delete(id);
        // if(true) throw new RuntimeException("testing rollback");
    }
    
}
