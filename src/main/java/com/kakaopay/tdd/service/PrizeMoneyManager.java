package com.kakaopay.tdd.service;

import com.kakaopay.tdd.model.LottoTicket;

public class PrizeMoneyManager {

    public static long FIRST_PRIZE_MONEY = 2000000000;
    public static long SECOND_PRIZE_MONEY = 30000000;
    public static long THIRD_PRIZE_MONEY = 1500000;
    public static long FOURTH_PRIZE_MONEY = 50000;
    public static long FIFTH_PRIZE_MONEY = 5000;

    public static long get(LottoTicket ticket) {
        switch (ticket.getGrade()) {
            case 1:
                return FIRST_PRIZE_MONEY;
            case 2:
                return SECOND_PRIZE_MONEY;
            case 3:
                return THIRD_PRIZE_MONEY;
            case 4:
                return FOURTH_PRIZE_MONEY;
            case 5:
                return FIFTH_PRIZE_MONEY;
            default:
                return 0;
        }
    }
}
