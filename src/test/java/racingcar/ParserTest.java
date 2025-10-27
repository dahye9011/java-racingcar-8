package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class ParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    @DisplayName("자동차 이름을 쉼표(,)를 기준으로 구분한다.")
    void 자동차_이름_구분_테스트() {
        // given
        String input = "a,b,c";

        // when
        List<String> result = parser.nameParse(input);

        // then
        assertThat(result).contains("a", "b", "c");
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-10"})
    @DisplayName("이동 시도 횟수가 0 또는 음수인 경우, IllegalArgumentException 이 발생한다.")
    void 이동_시도_횟수_0_이하_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseTryCount(input);
        });
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"a", "", " ", "a10"})
    @DisplayName("이동 시도 횟수가 숫자(문자, null, 빈 값, 공백)가 아닌 경우, IllegalArgumentException 이 발생한다.")
    void 이동_시도_횟수_숫자_아님_예외_테스트(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            parser.parseTryCount(input);
        });
    }
}
