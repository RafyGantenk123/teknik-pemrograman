package com.p2p.domain;

import com.p2p.service.LoanService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class LoanServiceTest {

    private static final Logger logger = LogManager.getLogger(LoanServiceTest.class);

    // =====================================================
    // TC-01: Borrower tidak terverifikasi → Exception
    // =====================================================
    @Test
    void shouldRejectLoanWhenBorrowerNotVerified() {
        logger.info("=== TC-01: shouldRejectLoanWhenBorrowerNotVerified ===");

        // Arrange
        Borrower borrower = new Borrower(false, 700);
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(1000);

        // Act & Assert
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, amount);
        });

        logger.info("TC-01 PASSED - Exception: {}", ex.getMessage());
        assertEquals("Borrower not verified", ex.getMessage());
    }

    // =====================================================
    // TC-02: Amount ≤ 0 → Exception
    // =====================================================
    @Test
    void shouldRejectLoanWhenAmountIsZeroOrNegative() {
        logger.info("=== TC-02: shouldRejectLoanWhenAmountIsZeroOrNegative ===");

        // Arrange
        Borrower borrower = new Borrower(true, 700); // Borrower valid
        LoanService loanService = new LoanService();
        BigDecimal invalidAmount = BigDecimal.ZERO;  // Amount = 0

        // Act & Assert
        Exception ex = assertThrows(IllegalArgumentException.class, () -> {
            loanService.createLoan(borrower, invalidAmount);
        });

        logger.info("TC-02 PASSED - Exception: {}", ex.getMessage());
        assertEquals("Amount harus lebih dari 0", ex.getMessage());
    }

    // =====================================================
    // TC-03: Credit score tinggi → APPROVED
    // =====================================================
    @Test
    void shouldApproveLoanWhenCreditScoreHigh() {
        logger.info("=== TC-03: shouldApproveLoanWhenCreditScoreHigh ===");

        // Arrange
        Borrower borrower = new Borrower(true, 700); // Credit score ≥ 600
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        logger.info("TC-03 PASSED - Loan status: {}", loan.getStatus());
        assertEquals(Loan.Status.APPROVED, loan.getStatus());
    }

    // =====================================================
    // TC-04: Credit score rendah → REJECTED
    // =====================================================
    @Test
    void shouldRejectLoanWhenCreditScoreLow() {
        logger.info("=== TC-04: shouldRejectLoanWhenCreditScoreLow ===");

        // Arrange
        Borrower borrower = new Borrower(true, 500); // Credit score < 600
        LoanService loanService = new LoanService();
        BigDecimal amount = BigDecimal.valueOf(5000);

        // Act
        Loan loan = loanService.createLoan(borrower, amount);

        // Assert
        logger.info("TC-04 PASSED - Loan status: {}", loan.getStatus());
        assertEquals(Loan.Status.REJECTED, loan.getStatus());
    }
}