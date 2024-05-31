package com.azka.schoolmanagementsystem.controller;

import com.azka.schoolmanagementsystem.entity.Payment;
import com.azka.schoolmanagementsystem.service.PaymentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
@Tag(name = "Payment", description = "Payment API")
public class PaymentController {
    @Autowired
    private final PaymentService paymentService;
    private static final Logger logger = LoggerFactory.getLogger(PaymentController.class);

    @PostMapping
    @Operation(summary = "Create a new payment", description = "Adds a new payment to the system")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Payment created successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content)
    })
    public ResponseEntity<Payment> createPayment(@Valid @RequestBody Payment payment) {
        logger.info("Creating new payment: {}", payment);
        Payment savedPayment = paymentService.createPayment(payment);
        return new ResponseEntity<>(savedPayment, HttpStatus.CREATED);
    }

    @GetMapping
    @Operation(summary = "Get all payments", description = "Retrieves a list of all payments")
    @ApiResponse(responseCode = "200", description = "List of payments", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class)))
    public ResponseEntity<List<Payment>> getAllPayments() {
        logger.info("Retrieving all payments");
        List<Payment> payments = paymentService.getAllPayments();
        return new ResponseEntity<>(payments, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get specific payment", description = "Retrieves payment by id")
    @ApiResponse(responseCode = "200", description = "Gets payment by ID", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class)))
    public ResponseEntity<Payment> getPaymentById(@PathVariable Long id) {
        logger.info("Retrieving payment with id: {}", id);
        Optional<Payment> payment = paymentService.getPaymentById(id);
        return payment.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a Payment", description = "Updates an existing Payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Payment updated successfully", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Payment.class))),
            @ApiResponse(responseCode = "400", description = "Invalid request body", content = @Content),
            @ApiResponse(responseCode = "404", description = "Payment not found", content = @Content)
    })
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @Valid @RequestBody Payment payment) {
        logger.info("Updating payment with id: {}", id);
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return ResponseEntity.ok(updatedPayment);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Payment", description = "Deletes an existing Payment")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Payment deleted successfully", content = @Content),
            @ApiResponse(responseCode = "404", description = "Payment not found", content = @Content)
    })
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        logger.info("Deleting payment with id: {}", id);
        paymentService.deletePayment(id);
        return ResponseEntity.noContent().build();
    }
}