package com.optimagrowth.license.service;

import com.optimagrowth.license.config.ServiceConfig;
import com.optimagrowth.license.model.License;
import com.optimagrowth.license.repository.LicenseRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class LicenseService {
    private MessageSource messageSource;
    private LicenseRepository repository;

    private ServiceConfig config;

    public License getLicense(String licenseId, String organizationId) {
        License license = repository.findByOrganizationIdAndLicenseId(organizationId, licenseId);
        if (null == license) {
            throw new IllegalArgumentException(String.format(messageSource.getMessage("license.search.error.message", null, null), licenseId, organizationId));
        }
        return license.withComment(config.getProperty());
    }

    public License createLicense(License license) {
        license.setLicenseId(UUID.randomUUID().toString());
        repository.save(license);
        return license.withComment(config.getProperty());
    }

    public License updateLicense(License license, String organizationId) {
        repository.save(license);
        return license.withComment(config.getProperty());
    }

    public String deleteLicense(String licenseId, String organizationId) {
        String responseMessage = null;
        License license = new License();
        license.setLicenseId(licenseId);
        repository.delete(license);
        return String.format(messageSource.getMessage("license.delete.message", null, null),licenseId);
    }
}
