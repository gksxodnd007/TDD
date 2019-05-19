package com.kakaopay.tdd;

import com.kakaopay.tdd.model.LottoTicket;
import com.kakaopay.tdd.service.LottoIssue;
import com.kakaopay.tdd.service.PrizeMoneyManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoApplication {

    public static void main(String... args) {

        System.out.println("구입 금액을 입력해 주세요");

        int purchaseAmount = 8000;
        System.out.println(purchaseAmount);

        List<LottoTicket> tickets = LottoIssue.generateLottoTicket(purchaseAmount);
        tickets.forEach(it -> {
            it.getNumbers().sort(Integer::compareTo);
            System.out.println(it.getNumbers().toString());
        });

        System.out.println("지난주 당첨 번호를 입력해 주세요");
        List<Integer> winNumbers = new ArrayList<>();

        String inputValue = "1,4,5,18,25,33";
        System.out.println(inputValue);

        Arrays.asList(inputValue.split(","))
                .forEach(it -> winNumbers.add(Integer.parseInt(it)));

        System.out.println("보너스 번호를 입력해 주세요");

        int bonusNumber = 40;
        System.out.println(bonusNumber);
        System.out.println("-------------------------------");

        tickets.forEach(it -> it.grantGrade(winNumbers, bonusNumber));

        List<Long> results = tickets.stream()
                .map(PrizeMoneyManager::get)
                .collect(Collectors.toList());

        results.forEach(it -> System.out.println("당첨 금액 : " + it));
    }
}
