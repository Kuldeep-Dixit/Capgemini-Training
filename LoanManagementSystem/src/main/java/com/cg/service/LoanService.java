package com.cg.service;

import com.cg.entity.Loan;
import java.util.List;

public interface LoanService {

    public Loan applyLoan(Loan loan);

    public List<Loan> getAllLoans();

    public Loan getLoanById(Long id);

    public Loan updateLoanStatus(Long id, String status);
}