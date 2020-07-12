package com.springframework.sfgpetclinic.services.map;

import com.springframework.sfgpetclinic.model.Vet;
import com.springframework.sfgpetclinic.model.VetSpeciality;
import com.springframework.sfgpetclinic.services.VetService;
import com.springframework.sfgpetclinic.services.VetSpecialityService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class VetServiceMap extends AbstractMapService<Vet,Long> implements VetService{

    private final VetSpecialityService specialityService;

    public VetServiceMap(VetSpecialityService specialityService) {
        this.specialityService = specialityService;
    }

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(Vet object) {

        if (object.getSpecialities().size()>0){
            object.getSpecialities().forEach(speciality -> {
                if (speciality.getId() == null){
                    VetSpeciality savedSpecility = specialityService.save(speciality);
                    speciality.setId(savedSpecility.getId());
                }
            });
        }

        return super.save(object);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
