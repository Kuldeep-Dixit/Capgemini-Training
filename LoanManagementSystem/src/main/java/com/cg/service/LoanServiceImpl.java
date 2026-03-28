package com.cg.service;

import com.cg.entity.Loan;
import com.cg.repository.LoanRepository;
import com.cg.exception.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanServiceImpl implements LoanService {

    @Autowired
    private LoanRepository repository;

    @Override
    public Loan applyLoan(Loan loan) {

        // Rule 1 & 2: Amount validation
        if (loan.getAmount() == null || loan.getAmount() < 1 || loan.getAmount() > 5000000) {
            throw new InvalidLoanAmountException(
                    "Amount must be between 1 and 50,00,000");
        }

        // Rule 3: Prevent duplicate PENDING booking
        Optional<Loan> opt = repository.findByUserNameAndStatus(
                loan.getUserName(),
                "PENDING"
        );
        if(!opt.isEmpty()) {
        	throw new DuplicateLoanApplicationException(
                    "User already has a pending booking");
        }
        loan.setStatus("PENDING");

        return repository.save(loan);
    }

    @Override
    public List<Loan> getAllLoans() {
        return repository.findAll();
    }

    @Override
    public Loan getLoanById(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new LoanNotFoundException(
                                "Booking not found with id: " + id));
    }

    @Override
    public Loan updateLoanStatus(Long id, String status) {

        Loan loan = getLoanById(id);

        String normalizedStatus = status.toUpperCase();

            if (!normalizedStatus.equals("BOOKED") &&
            !normalizedStatus.equals("CANCELLED")) {
            throw new RuntimeException(
                    "Invalid status. Use BOOKED or CANCELLED");
        }

        loan.setStatus(normalizedStatus);

        return repository.save(loan);
    }
}