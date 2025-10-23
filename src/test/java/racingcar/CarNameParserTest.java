package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameParserTest {
    @Test
    @DisplayName("자동차 이름을 쉼표(,)를 기준으로 구분한다.")
    void 자동차_이름_구분() {
        // given
        CarNameParser parser = new CarNameParser();
        String input = "a,b,c";

        // when
        List<String> result = parser.nameParse(input);

        // then
        assertThat(result).contains("a", "b", "c");
    }
}
