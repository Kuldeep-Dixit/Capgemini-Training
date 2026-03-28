package com.cg.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "loan")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loanId")
    private Long loanId;

    @Column(name = "applicantName")
    private String userName;

    @Column(name = "loanAmount")
    private Double amount;

    @Column(name = "status")
    private String status; // PENDING, BOOKED, CANCELLED

    public Loan() {}

    public Loan(String userName, Double amount, String status) {
        this.userName = userName;
        this.amount = amount;
        this.status = status;
    }

    public Long getLoanId() { return loanId; }

    public String getUserName() { return userName; }

    public void setUserName(String userName) { this.userName = userName; }

    public Double getAmount() { return amount; }

    public void setAmount(Double amount) { this.amount = amount; }

    public String getStatus() { return status; }

    public void setStatus(String status) { 
    	this.status = status; 
    	}
}