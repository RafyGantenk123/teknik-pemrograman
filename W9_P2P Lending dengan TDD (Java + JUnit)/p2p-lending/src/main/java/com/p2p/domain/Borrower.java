package com.p2p.domain;

public class Borrower {
    private final boolean verified;
    private final int creditScore;

    public Borrower(boolean verified, int creditScore) {
        this.verified = verified;
        this.creditScore = creditScore;
    }

    public boolean isVerified() {
        return verified;
    }

    public int getCreditScore() {
        return creditScore;
    }

    // Domain behavior (hasil refactor TC-01)
    public boolean canApplyLoan() {
        return verified;
    }
}
