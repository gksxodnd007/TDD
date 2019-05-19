package com.kakaopay.tdd;

import com.kakaopay.tdd.model.LottoTicket;
import com.kakaopay.tdd.service.LottoIssue;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class IssueLottoTest {

    private static int ONE_TICKET_AMOUNT = 1000;
    private static int TWO_TICKET_AMOUNT = 2500;
    private static int THREE_TICKET_AMOUNT = 3000;
    private static int LOTTO_NUMBER_COUNT = 6;
    private static int LOTTO_MAX_NUMBER = 45;

    @Test
    void 발급된_로또_번호가_정상적인_경우() {
        List<LottoTicket> tickets = LottoIssue.generateLottoTicket(ONE_TICKET_AMOUNT);

        assertEquals(LOTTO_NUMBER_COUNT, (int) tickets.get(0).getNumbers().stream().distinct().count());
        assertTrue(LOTTO_MAX_NUMBER >= tickets.get(0).getNumbers().stream().max(Integer::compareTo).get());
    }

    @Test
    void 천원으로_로또_번호_발급한_경우() {
        List<LottoTicket> tickets = LottoIssue.generateLottoTicket(ONE_TICKET_AMOUNT);

        assertEquals(1, tickets.size());
    }

    @Test
    void 이천원_오백원_으로_로또_번호_발급한_경우() {
        List<LottoTicket> tickets = LottoIssue.generateLottoTicket(TWO_TICKET_AMOUNT);

        assertEquals(2, tickets.size());
        assertNotEquals(tickets.get(0), tickets.get(1));
    }

    @Test
    void 삼천원으로_로또_번호_발급한_경우() {
        List<LottoTicket> tickets = LottoIssue.generateLottoTicket(THREE_TICKET_AMOUNT);

        assertEquals(3, tickets.size());
        assertNotEquals(tickets.get(0), tickets.get(1));
        assertNotEquals(tickets.get(0), tickets.get(2));
        assertNotEquals(tickets.get(1), tickets.get(2));
    }
}
