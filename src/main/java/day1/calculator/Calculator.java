package day1.calculator;

import java.util.regex.Pattern;

/**
 * 싱글톤을 고려하지 않기 떄문에, 동시성 이슈는 생략합니다.
 */
class Calculator {

    private final static String ALLOWED_INPUT_PATTERN = "^[0-9]*$";
    private long currentResult;
    private Operator currentOperator;

    public long execute(String input) {

        String[] inputArray = input.split("\\s+");

        currentResult = Long.parseLong(inputArray[0]);

        for (String element : inputArray) {
            if (currentOperator != null) {
                currentResult = calculate(element, currentOperator);
            }
            saveOperator(element);
        }
        return currentResult;
    }

    private long calculate(String input, Operator operator) {
        return isAllowedNumberFormat(input) ? operator.operate(currentResult, Integer.parseInt(input)) : currentResult;
    }

    private boolean isAllowedNumberFormat(String input) {
        return Pattern.matches(ALLOWED_INPUT_PATTERN, input);
    }

    private void saveOperator(String input) {
        if (isAllowedNumberFormat(input)) {
            return;
        }
        currentOperator = Operator.findByValue(input);
    }
}
