package lotto.dto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public record Lotto(List<Integer> numbers) {

    public Lotto(List<Integer> numbers) {
        this.numbers = sortNumberInAscending(numbers);
    }

    private List<Integer> sortNumberInAscending(List<Integer> numbers) {
        return numbers.stream()
                .sorted(Comparator.naturalOrder())
                .toList();
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}