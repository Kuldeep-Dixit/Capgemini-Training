package com.cg.controller;

import com.cg.entity.Loan;
import com.cg.service.LoanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @Autowired
    private LoanService service;

    // Apply Loan
    @PostMapping
    public Loan applyLoan(@RequestBody Loan loan) {
        return service.applyLoan(loan);
    }

    // View All Loans
    @GetMapping
    public List<Loan> getAllLoans() {
        return service.getAllLoans();
    }

    // View Loan by ID
    @GetMapping("/{id}")
    public Loan getLoanById(@PathVariable Long id) {
        return service.getLoanById(id);
    }

    // Update status
    @PutMapping("/{id}/{status}")
    public Loan updateStatus(@PathVariable Long id,
                             @PathVariable String status) {
        return service.updateLoanStatus(id, status);
    }
}