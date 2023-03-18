package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("'1,2'을 ',' 로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.")
    void splitTest() {

        String value = "1,2";
        String noSplitValue = "1";

        String[] split = value.split(",");
        String[] noSplitArray = noSplitValue.split(",");

        assertThat(value.contains(split[0])).isTrue();
        assertThat(value.contains(split[1])).isTrue();
        assertThat(noSplitValue.contains(noSplitArray[0])).isTrue();

    }

    @Test
    @DisplayName("'(1,2)' 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 '1,2'를 반환하도록 구현한다.")
    void splitTest2() {

        String firstTest = "(1,2)";
        String secondTest = "(1,2,3,4,5)";

        String substring = firstTest.substring(firstTest.indexOf("(") + 1, firstTest.indexOf(")"));
        String substring2 = secondTest.substring(secondTest.indexOf("(") + 1, secondTest.indexOf(")"));

        String expectedValue = "1,2";
        String expectedValue2 = "1,2,3,4,5";

        assertThat(substring).isEqualTo(expectedValue);
        assertThat(substring2).isEqualTo(expectedValue2);

    }
    @Test
    @DisplayName("'abc' 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.")
    void splitTest3() {

        String testValue = "abc";

        char result = testValue.charAt(1);

        char expectedValue = 'b';

        assertThat(result).isEqualTo(expectedValue);
    }

    @Test
    @DisplayName("'abc' 값이 주어졌을 때 주어진 문자 범위 초과하면 'StringIndexOutOfBoundsException' 발생")
    void splitTest3_Exception() {

        String testValue = "abc";

        int outOfBoundIndex = testValue.length() + 1;

        assertThatThrownBy(() -> testValue.charAt(outOfBoundIndex)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
