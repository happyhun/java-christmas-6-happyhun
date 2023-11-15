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

    @ParameterizedTest
    @ValueSource(strings = {"없는메뉴-1", "해산물파스타-0", "해산물파스타", "시저샐러드-1,시저샐러드-1"})
    void 주문_예외_테스트(String input) {
        assertThatThrownBy(() -> InputValidator.getValidOrder(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
    }

}