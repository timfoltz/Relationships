package com.tim.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tim.relationships.models.License;
import com.tim.relationships.repos.LicenseRepo;

@Service
public class LicenseService {
	
	@Autowired
	private LicenseRepo licenseRepo;
//	******Create******
	public License createLicense(License license) {
//		return licenseRepo.save(license);
//		Emilie's way -----
		licenseRepo.save(license);
        Long num = license.getId();
        String str = num.toString();
        int zeros = 6 - str.length();
        for(int i = 0; i < zeros; i++) {
            str = "0" + str;
        }
        license.setNumber(str);
    
		return licenseRepo.save(license);
	}

	
//	******Read ONE******
	public License findLicense(Long id) {
		Optional<License> optionalLicense = licenseRepo.findById(id);
		return optionalLicense !=null ? optionalLicense.get() : null;
	}
//	******Read ALL******
	public List<License> allLicenses()	{
		return licenseRepo.findAll();
	}
//	******Update******
	public void updateLicense(License license) {
		licenseRepo.save(license);
	}
//	******Destroy/Delete******
	public void deleteLicense(Long id) {
		licenseRepo.deleteById(id);
	}
}
