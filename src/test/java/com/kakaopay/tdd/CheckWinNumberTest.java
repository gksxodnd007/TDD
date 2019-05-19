package com.kakaopay.tdd;

import com.kakaopay.tdd.model.LottoTicket;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CheckWinNumberTest {

    private static List<Integer> WIN_NUMBERS;
    private static int BONUS_NUMBER = 44;

    static {
         WIN_NUMBERS = new ArrayList<>();
         WIN_NUMBERS.add(4);
         WIN_NUMBERS.add(6);
         WIN_NUMBERS.add(11);
         WIN_NUMBERS.add(13);
         WIN_NUMBERS.add(28);
         WIN_NUMBERS.add(33);
    }

    @Test
    void 로또_1등_인경우() {
        LottoTicket ticket = mockLottoTicketWhenFirstGrade();
        ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

        Assertions.assertEquals(1, ticket.getGrade());
    }

    @Test
    void 로또_2등_인경우() {
        LottoTicket ticket = mockLottoTicketWhenSecondGrade();
        ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

        Assertions.assertEquals(2, ticket.getGrade());
    }

    @Test
    void 로또_3등_인경우() {
        LottoTicket ticket = mockLottoTicketWhenThirdGrade();
        ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

        Assertions.assertEquals(3, ticket.getGrade());
    }

    @Test
    void 로또_4등_인경우() {
        LottoTicket ticket = mockLottoTicketWhenFourthGrade();
        ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

        Assertions.assertEquals(4, ticket.getGrade());
    }

    @Test
    void 로또_5등_인경우() {
        LottoTicket ticket = mockLottoTicketWhenFifthGrade();
        ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

        Assertions.assertEquals(5, ticket.getGrade());
    }

    private LottoTicket mockLottoTicketWhenFirstGrade() {
        return LottoTicket.newTicket(WIN_NUMBERS);
    }

    private LottoTicket mockLottoTicketWhenSecondGrade() {
        List<Integer> numbers = new ArrayList<>(WIN_NUMBERS.subList(0, 5));
        numbers.add(BONUS_NUMBER);
        return LottoTicket.newTicket(numbers);
    }

    private LottoTicket mockLottoTicketWhenThirdGrade() {
        List<Integer> numbers = new ArrayList<>(WIN_NUMBERS.subList(0, 5));
        numbers.add(1);
        return LottoTicket.newTicket(numbers);
    }

    private LottoTicket mockLottoTicketWhenFourthGrade() {
        List<Integer> numbers = new ArrayList<>(WIN_NUMBERS.subList(0, 4));
        numbers.add(1);
        numbers.add(2);
        return LottoTicket.newTicket(numbers);
    }

    private LottoTicket mockLottoTicketWhenFifthGrade() {
        List<Integer> numbers = new ArrayList<>(WIN_NUMBERS.subList(0, 3));
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        return LottoTicket.newTicket(numbers);
    }
}
