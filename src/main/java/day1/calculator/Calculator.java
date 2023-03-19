package day1.calculator;

import java.util.regex.Pattern;

class Calculator {

    private final static String ALLOW_INPUT_PATTERN = "^[0-9]*$";
    private Operator currentOperator;

    public long execute(String input) {

        String[] strArray = input.split(" ");

        int result = Integer.parseInt(strArray[0]);

        for (String element : strArray) {
            if (currentOperator != null) {
                result = calculate(result, element, currentOperator);
            }
            saveOperator(element);
        }
        return result;
    }

    private int calculate(int result, String input, Operator operator) {

        if (Pattern.matches(ALLOW_INPUT_PATTERN, input)) {
            return operator.operate(result, Integer.parseInt(input));
        }

        saveOperator(input);

        return result;
    }

    private void saveOperator(String input) {
        if (Character.isDigit(input.charAt(0))) {
            return;
        }
        currentOperator = Operator.findByValue(input);
    }
}
