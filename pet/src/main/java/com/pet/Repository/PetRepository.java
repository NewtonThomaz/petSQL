package com.pet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pet.Entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long>{

}
