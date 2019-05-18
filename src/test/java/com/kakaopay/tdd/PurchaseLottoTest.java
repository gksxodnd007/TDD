package com.kakaopay.tdd;

import com.kakaopay.tdd.exception.BadPurchaseAmountException;
import com.kakaopay.tdd.service.PurchaseLotto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PurchaseLottoTest {

    private static final int TEST_PURCHASE_AMOUNT_NORMAL_CASE = 2000;
    private static final int TEST_PURCHASE_AMOUNT_ABNORMAL_CASE = 2500;
    private static final int TEST_PURCHASE_AMOUNT_DEFICIENT_CASE = 500;
    private static final int EXPECT_RESULT = 2;

    @Test
    void 구입금액이_1000원_단위인_경우() {
        assertEquals(EXPECT_RESULT, PurchaseLotto.inputPurchaseAmount(TEST_PURCHASE_AMOUNT_NORMAL_CASE));
    }

    @Test
    void 구입금액이_1000원_단위가_아닌경우() {
        assertEquals(EXPECT_RESULT, PurchaseLotto.inputPurchaseAmount(TEST_PURCHASE_AMOUNT_ABNORMAL_CASE));
    }

    @Test
    void 구입금액이_1000원_미만인경우() {
        assertThrows(BadPurchaseAmountException.class, () -> PurchaseLotto.inputPurchaseAmount(TEST_PURCHASE_AMOUNT_DEFICIENT_CASE));
    }
}
