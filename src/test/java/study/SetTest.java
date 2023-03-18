package study;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class SetTest {


    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void containsTest() {
      assertThat(numbers.contains(1)).isTrue();
      assertThat(numbers.contains(2)).isTrue();
      assertThat(numbers.contains(3)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3","4,5,6","7,8,9"})
    void parameterized_test(int a, int b, int c) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        assertThat(numbers.contains(a)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({"1,2,3","4,5,6","7,8,9"})
    void parameterized_test2(int a, int b, int c) {
        Set<Integer> numbers = new HashSet<>();
        numbers.add(a);
        numbers.add(b);
        numbers.add(c);
        assertThat(numbers.contains(a)).isTrue();
    }
}
