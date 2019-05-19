package com.kakaopay.tdd.model;

import java.util.List;
import java.util.Objects;

public class LottoTicket {
    
    private List<Integer> numbers;

    private LottoTicket(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new RuntimeException();
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public static LottoTicket newTicket(List<Integer> numbers) {
         return new LottoTicket(numbers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTicket)) return false;
        LottoTicket that = (LottoTicket) o;
        return numbers.equals(that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}