package day1.calculator;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Operator {

    PLUS("+", (a, b) -> a + b),
    MINUS("-", (a, b) -> a - b),
    MULTIPLY("*", (a, b) -> a * b),
    DIVIDE("/", (a, b) -> {
        if (b == 0) throw new ArithmeticException("0으로 나눌 수 없습니다.");
        return a / b;
    }),
    ;

    private final String value;
    private final BiFunction<Long, Long, Long> operateFunction;

    Operator(String value, BiFunction<Long, Long, Long> operateFunction) {
        this.value = value;
        this.operateFunction = operateFunction;
    }

    public String getOperator() {
        return value;
    }

    public long operate(long a, long b) {
        return operateFunction.apply(a, b);
    }

    public static Operator findByValue(String value) {
        return Arrays.stream(Operator.values())
            .filter(operator -> operator.getOperator().equals(value))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(
                "해당 연산자를 찾을 수 없습니다. 입력받은 연산자 : " + value));
    }
}
