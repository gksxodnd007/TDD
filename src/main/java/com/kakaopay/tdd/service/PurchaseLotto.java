package com.kakaopay.tdd.service;

import com.kakaopay.tdd.exception.BadPurchaseAmountException;

public class PurchaseLotto {

    public static int inputPurchaseAmount(int amount) {
        if (amount < 1000) {
            throw new BadPurchaseAmountException();
        }

        return amount / 1000;
    }
}
