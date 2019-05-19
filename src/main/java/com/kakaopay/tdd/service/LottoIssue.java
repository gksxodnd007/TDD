package com.kakaopay.tdd.service;

import com.kakaopay.tdd.model.LottoTicket;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoIssue {

    private static List<Integer> lottoNumberList;

    static {
        lottoNumberList = IntStream.range(1, 46)
                .boxed()
                .collect(Collectors.toList());
    }

    public static List<LottoTicket> generateLottoTicket(int amount) {
        int count = PurchaseLotto.inputPurchaseAmount(amount);
        List<LottoTicket> tickets = new ArrayList<>(count);

        for (int i = 0; i < count; i++) {
            tickets.add(generateLottoTicket());
        }
        return tickets;
    }

    private static LottoTicket generateLottoTicket() {
        List<Integer> ticketNumbers = new ArrayList<>(6);
        Collections.shuffle(lottoNumberList);

        Flux.fromIterable(lottoNumberList)
                .limitRequest(6)
                .doOnNext(ticketNumbers::add)
                .subscribe();

        return LottoTicket.newTicket(ticketNumbers);
    }
}