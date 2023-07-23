package com.javaegitimleri.petclinic.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.javaegitimleri.petclinic.model.Owner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceException;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("dev")
@Transactional
public class OwnerRepositoryTests {
	@Autowired
	private OwnerRepository ownerRepository;

    @PersistenceContext
    private EntityManager entityManager;

	@Test(expected = PersistenceException.class)
	public void testCreateOwner() {
		Owner owner = new Owner();
		owner.setFirstName(null);
		owner.setLastName(null);
		
		ownerRepository.create(owner);

        entityManager.flush();
	}
}