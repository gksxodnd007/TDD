package com.kakaopay.tdd.model;

import java.util.List;
import java.util.Objects;

public class LottoTicket {

    private static final int FIRST_GRADE_CONDITION = 6;
    private static final int SECOND_OR_THIRD_GRADE_CONDITION = 5;
    private static final int FOURTH_GRADE_CONDITION = 4;
    private static final int FIFTH_GRADE_CONDITION = 3;

    private List<Integer> numbers;
    private int grade = 0;

    private LottoTicket(List<Integer> numbers) {
        if (numbers.size() > 6) {
            throw new RuntimeException();
        }

        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int getGrade() {
        return this.grade;
    }

    public void grantGrade(List<Integer> winNumbers, int bonusNumber) {
        int count = 0;

        for (Integer number : winNumbers) {
            if (numbers.contains(number)) {
                count++;
            }
        }

        switch (count) {
            case FIRST_GRADE_CONDITION:
                this.grade = 1;
                return;
            case SECOND_OR_THIRD_GRADE_CONDITION: {
                if (containsBonus(bonusNumber)) {
                    this.grade = 2;
                    return;
                }

                this.grade = 3;
                return;
            }
            case FOURTH_GRADE_CONDITION:
                this.grade = 4;
                return;
            case FIFTH_GRADE_CONDITION:
                this.grade = 5;
                return;
        }

        this.grade = 0;
    }

    private boolean containsBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
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