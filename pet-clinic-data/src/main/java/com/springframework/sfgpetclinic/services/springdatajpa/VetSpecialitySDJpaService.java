package com.springframework.sfgpetclinic.services.springdatajpa;

import com.springframework.sfgpetclinic.model.VetSpeciality;
import com.springframework.sfgpetclinic.repositories.VetSpecialityRepository;
import com.springframework.sfgpetclinic.services.VetSpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springdatajpa")
public class VetSpecialitySDJpaService implements VetSpecialityService {

    private final VetSpecialityRepository vetSpecialityRepository;

    public VetSpecialitySDJpaService(VetSpecialityRepository vetSpecialityRepository) {
        this.vetSpecialityRepository = vetSpecialityRepository;
    }

    @Override
    public Set<VetSpeciality> findAll() {
        Set<VetSpeciality> vetSpecialities = new HashSet<>();
        vetSpecialityRepository.findAll().forEach(vetSpecialities::add);
        return vetSpecialities;
    }

    @Override
    public VetSpeciality findById(Long aLong) {
        return vetSpecialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public VetSpeciality save(VetSpeciality object) {
        return vetSpecialityRepository.save(object);
    }

    @Override
    public void delete(VetSpeciality object) {
        vetSpecialityRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        vetSpecialityRepository.deleteById(aLong);
    }
}
