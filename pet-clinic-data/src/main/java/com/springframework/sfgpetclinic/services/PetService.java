package com.springframework.sfgpetclinic.services;

import com.springframework.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findByid(long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}
