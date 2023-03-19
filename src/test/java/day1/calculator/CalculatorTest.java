package day1.calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Scanner를 통한 입력은 생략하여 진행합니다.
 */
public class CalculatorTest {
    
    @Test
    @DisplayName("주어진 입력값의 순서대로 연산합니다.")
    void calculate_test() {

        String testValue = "2 + 3 - 1 * 2 / 2";

        long result = new Calculator().execute(testValue);

        long expectedValue = 4;

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("입력값이 null일때 NPE 발생힙니다.")
    void input_null_test() {

        String testValue = null;

        assertThatThrownBy(() -> new Calculator().execute(testValue)).isInstanceOf(NullPointerException.class);
    }

    @Test
    @DisplayName("입력값이 null일때 NumberFormatException 발생힙니다.")
    void input_blank_test() {

        String testValue = "";

        assertThatThrownBy(() -> new Calculator().execute(testValue)).isInstanceOf(NumberFormatException.class);
    }

    @Test
    @DisplayName("나누는 숫자가 0일때, IllegalArgumentException 발생힙니다.")
    void divided_by_zero_test() {

        String testValue = "2 + 3 - 1 * 2 / 0";

        assertThatThrownBy(() -> new Calculator().execute(testValue)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사칙연산에 *, -, +, / 외의 연산 입력시 IllegalArgumentException 발생합니다.")
    void invalid_operator_test() {

        String testValue = "2 ! 3 - 1 * 2 / 0";

        assertThatThrownBy(() -> new Calculator().execute(testValue)).isInstanceOf(IllegalArgumentException.class);
    }


}
