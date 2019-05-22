package com.kakaopay.tdd;

import com.kakaopay.tdd.model.LottoTicket;
import com.kakaopay.tdd.service.PrizeMoneyManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoResultTest {

    private static List<Integer> WIN_NUMBERS;
    private static int BONUS_NUMBER = 44;
    private static long PURCHASE_AMOUNT = 8000;
    private static long EXPECT_WIN_MONEY = 5000;
    private static double EXPECT_EARNING_RATE = 5000.00 / 8000.00;

    static {
         WIN_NUMBERS = new ArrayList<>();
         WIN_NUMBERS.add(4);
         WIN_NUMBERS.add(6);
         WIN_NUMBERS.add(11);
         WIN_NUMBERS.add(13);
         WIN_NUMBERS.add(28);
         WIN_NUMBERS.add(33);
    }

    @DisplayName("로또 번호 당첨 여부 체크 테스트")
    @Nested
    class CheckWinNumber {

        @Test
        void 로또_1등_인경우() {
            LottoTicket ticket = mockLottoTicketWhenFirstGrade();
            ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(1, ticket.getGrade());
        }

        @Test
        void 로또_2등_인경우() {
            LottoTicket ticket = mockLottoTicketWhenSecondGrade();
            ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(2, ticket.getGrade());
        }

        @Test
        void 로또_3등_인경우() {
            LottoTicket ticket = mockLottoTicketWhenThirdGrade();
            ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(3, ticket.getGrade());
        }

        @Test
        void 로또_4등_인경우() {
            LottoTicket ticket = mockLottoTicketWhenFourthGrade();
            ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(4, ticket.getGrade());
        }

        @Test
        void 로또_5등_인경우() {
            LottoTicket ticket = mockLottoTicketWhenFifthGrade();
            ticket.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(5, ticket.getGrade());
        }
    }

    @DisplayName("당첨금액 지급 테스트")
    @Nested
    class PrizeMoneyManagerTest {

        @Test
        void 당첨금액_1등인_경우() {
            LottoTicket mock = mockLottoTicketWhenFirstGrade();
            mock.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(PrizeMoneyManager.FIRST_PRIZE_MONEY, PrizeMoneyManager.get(mock));
        }

        @Test
        void 당첨금액_2등인_경우() {
            LottoTicket mock = mockLottoTicketWhenSecondGrade();
            mock.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(PrizeMoneyManager.SECOND_PRIZE_MONEY, PrizeMoneyManager.get(mock));
        }

        @Test
        void 당첨금액_3등인_경우() {
            LottoTicket mock = mockLottoTicketWhenThirdGrade();
            mock.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(PrizeMoneyManager.THIRD_PRIZE_MONEY, PrizeMoneyManager.get(mock));
        }

        @Test
        void 당첨금액_4등인_경우() {
            LottoTicket mock = mockLottoTicketWhenFourthGrade();
            mock.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(PrizeMoneyManager.FOURTH_PRIZE_MONEY, PrizeMoneyManager.get(mock));
        }

        @Test
        void 당첨금액_5등인_경우() {
            LottoTicket mock = mockLottoTicketWhenFifthGrade();
            mock.grantGrade(WIN_NUMBERS, BONUS_NUMBER);

            assertEquals(PrizeMoneyManager.FIFTH_PRIZE_MONEY, PrizeMoneyManager.get(mock));
        }
    }

    @Test
    void 수익률계산_검증() {
        double result = PrizeMoneyManager.calculateEarningRate(PURCHASE_AMOUNT, EXPECT_WIN_MONEY);

        assertEquals(EXPECT_EARNING_RATE, result);
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
