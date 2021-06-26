package com.yasar.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.dojo.models.Ninja;
import com.yasar.dojo.repositries.NinjaRepositry;


@Service
public class NinjaService {
    private final NinjaRepositry ninjaRepositry;
    
    public NinjaService(NinjaRepositry ninjaRepositry) {
        this.ninjaRepositry = ninjaRepositry;
    }
    public List<Ninja> allNinjas() {
        return ninjaRepositry.findAll();
    }
    public List<Ninja> allNinjasdojo(Long id) {
        return ninjaRepositry.allNinjasdojo(id);
    }
    public Ninja createNinja(Ninja b) {
        return ninjaRepositry.save(b);
    }
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepositry.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
}
