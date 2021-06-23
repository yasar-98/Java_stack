package com.yasar.license.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.yasar.license.models.License;
import com.yasar.license.repositries.LicenseRepositry;

@Service
public class LicenseService {
    private final LicenseRepositry licenseRepositry;
    
    public LicenseService(LicenseRepositry licenseRepositry) {
        this.licenseRepositry = licenseRepositry;
    }
    // returns all the Licenses
    public List<License> allLicenses() {
        return licenseRepositry.findAll();
    }
 // creates a License
    public License createLicense(License b) {
        return licenseRepositry.save(b);
    }
 // creates a License number
    public void createLicenseNumber(License b) {
    	License l = licenseRepositry.findTopByOrderByNumberDesc();
    	Integer a = Integer.parseInt(l.getNumber());
    	b.setNumber(String.format("%05d",++a));
    }
    // retrieves a License
    public License findLicense(Long id) {
        Optional<License> optionalLicense = licenseRepositry.findByPersonId(id);
        if(optionalLicense.isPresent()) {
            return optionalLicense.get();
        } else {
            return null;
        }
    }

}
