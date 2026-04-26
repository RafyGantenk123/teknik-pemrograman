package com.p2p.domain;

public class Loan {

    public enum Status {
        PENDING, APPROVED, REJECTED, FUNDED, ACTIVE, COMPLETED
    }

    private Status status = Status.PENDING;

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    // Domain behaviors
    public void approve() {
        this.status = Status.APPROVED;
    }

    public void reject() {
        this.status = Status.REJECTED;
    }
}
