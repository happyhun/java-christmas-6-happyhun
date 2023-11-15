package validation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1일", "1.0", "-1", "0", "32"})
    void 날짜_예외_테스트(String input) {
        assertThatThrownBy(() -> InputValidator.getValidDate(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
    }

}