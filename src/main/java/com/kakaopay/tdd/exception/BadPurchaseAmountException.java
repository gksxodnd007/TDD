package com.kakaopay.tdd.exception;

public class BadPurchaseAmountException extends RuntimeException {

    public BadPurchaseAmountException() {
    }

    public BadPurchaseAmountException(String msg) {
        super(msg);
    }
}
