package com.p2p.service;

import com.p2p.domain.Borrower;
import com.p2p.domain.Loan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;

public class LoanService {

    private static final Logger logger = LogManager.getLogger(LoanService.class);

    public Loan createLoan(Borrower borrower, BigDecimal amount) {
        logger.info("Memulai proses createLoan - amount: {}", amount);

        // Validasi borrower
        validateBorrower(borrower);

        // Validasi amount (TC-02)
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            logger.warn("Amount tidak valid: {}", amount);
            throw new IllegalArgumentException("Amount harus lebih dari 0");
        }

        Loan loan = new Loan();

        // Credit scoring (TC-03 & TC-04)
        if (borrower.getCreditScore() >= 600) {
            loan.approve();
            logger.info("Loan APPROVED - credit score: {}", borrower.getCreditScore());
        } else {
            loan.reject();
            logger.warn("Loan REJECTED - credit score: {} di bawah threshold", borrower.getCreditScore());
        }

        return loan;
    }

    private void validateBorrower(Borrower borrower) {
        if (!borrower.canApplyLoan()) {
            logger.error("Borrower belum terverifikasi KYC");
            throw new IllegalArgumentException("Borrower not verified");
        }
    }
}