package com.azka.schoolmanagementsystem.services.impl;

import com.azka.schoolmanagementsystem.entities.Payment;
import com.azka.schoolmanagementsystem.exceptions.ResourceNotFoundException;
import com.azka.schoolmanagementsystem.repositories.PaymentRepository;
import com.azka.schoolmanagementsystem.services.PaymentService;
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
public class PaymentServiceImpl implements PaymentService {

    private static final Logger logger = LoggerFactory.getLogger(PaymentServiceImpl.class);

    @Autowired
    private PaymentRepository paymentRepository;

    @Override
    @Transactional
    public Payment createPayment(Payment payment) {
        try {
            logger.info("Saving payment: {}", payment);
            return paymentRepository.save(payment);
        } catch (ConstraintViolationException ex) {
            logger.error("Validation failed for payment: {}", payment);
            Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
            violations.forEach(violation -> logger.error("Validation error: {}", violation.getMessage()));
            throw ex;
        }
    }

    @Override
    public List<Payment> getAllPayments() {
        logger.info("Retrieving all payments");
        return paymentRepository.findAll();
    }

    @Override
    public Optional<Payment> getPaymentById(Long id) {
        logger.info("Retrieving payment with id: {}", id);
        return paymentRepository.findById(id);
    }

    @Override
    @Transactional
    public Payment updatePayment(Long id, @Valid @RequestBody Payment payment) {
        logger.info("Updating payment with id: {}", id);
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));

        existingPayment.setStudentName(payment.getStudentName());
        existingPayment.setClassName(payment.getClassName());
        existingPayment.setTitle(payment.getTitle());
        existingPayment.setDescription(payment.getDescription());
        existingPayment.setAmount(payment.getAmount());
        existingPayment.setStatus(payment.getStatus());
        existingPayment.setDate(payment.getDate());

        return paymentRepository.save(existingPayment);
    }

    @Override
    @Transactional
    public void deletePayment(Long id) {
        logger.info("Deleting payment with id: {}", id);
        Payment existingPayment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found with id: " + id));
        paymentRepository.delete(existingPayment);
    }
}