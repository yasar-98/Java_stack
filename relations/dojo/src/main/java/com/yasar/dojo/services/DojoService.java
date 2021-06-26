package com.yasar.dojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.dojo.models.Dojo;
import com.yasar.dojo.repositries.DojoRepositry;

@Service
public class DojoService {
    private final DojoRepositry dojoRepository;
    
    public DojoService(DojoRepositry dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    public Dojo createDojo(Dojo b) {
        return dojoRepository.save(b);
    }
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalDojo = dojoRepository.findById(id);
        if(optionalDojo.isPresent()) {
            return optionalDojo.get();
        } else {
            return null;
        }
    }
}
