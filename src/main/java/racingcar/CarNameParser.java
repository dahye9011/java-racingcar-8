package racingcar;

import java.util.Arrays;
import java.util.List;

public class CarNameParser {
    public List<String> nameParse(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .filter(name -> !name.isEmpty())
                .toList();
    }
}