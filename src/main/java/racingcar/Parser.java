package racingcar;

import java.util.Arrays;
import java.util.List;

public class Parser {
    public List<String> nameParse(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();
    }

    public int parseTryCount(String tryCountInput) {
        try {
            int count = Integer.parseInt(tryCountInput);
            if (count <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}