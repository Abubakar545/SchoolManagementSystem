package com.azka.schoolmanagementsystem.service.impl;

import com.azka.schoolmanagementsystem.entity.Parent;
import com.azka.schoolmanagementsystem.exception.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.repository.ParentRepository;
import com.azka.schoolmanagementsystem.service.ParentService;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class ParentServiceImpl implements ParentService {

    private static final Logger logger = LoggerFactory.getLogger(ParentServiceImpl.class);

    @Autowired
    private ParentRepository parentRepository;

    @Override
    @Transactional
    public Parent saveParent(Parent parent) {
        try {
            logger.info("Saving parent: {}", parent);
            return parentRepository.save(parent);
        } catch (ConstraintViolationException ex) {
            logger.error("Validation failed for parent: {}", parent);
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
            violations.forEach(violation -> logger.error("Validation error: {}", violation.getMessage()));
            throw ex;
        }
    }

    @Override
    public List<Parent> getAllParents() {
        logger.info("Retrieving all parents");
        return parentRepository.findAll();
    }

    @Override
    @Transactional
    public Parent updateParent(Long id, @Valid @RequestBody Parent parent) {
        logger.info("Updating parent with id: {}", id);
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent not found with id: " + id));

        existingParent.setPhoto(parent.getPhoto());
        existingParent.setName(parent.getName());
        existingParent.setEmail(parent.getEmail());
        existingParent.setStreetAddress(parent.getStreetAddress());
        existingParent.setCity(parent.getCity());
        existingParent.setState(parent.getState());
        existingParent.setZipCode(parent.getZipCode());
        existingParent.setCountry(parent.getCountry());
        existingParent.setPhoneNumber(parent.getPhoneNumber());
        existingParent.setAlternatePhoneNumber(parent.getAlternatePhoneNumber());
        existingParent.setDateOfBirth(parent.getDateOfBirth());
        existingParent.setOccupation(parent.getOccupation());
        existingParent.setRelationship(parent.getRelationship());

        return parentRepository.save(existingParent);
    }

    @Override
    @Transactional
    public void deleteParent(Long id) {
        logger.info("Deleting parent with id: {}", id);
        Parent existingParent = parentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Parent not found with id: " + id));
        parentRepository.delete(existingParent);
    }

    @Override
    public Optional<Parent> getParentById(Long id) {
        logger.info("Retrieving parent with id: {}", id);
        return parentRepository.findById(id);
    }
}