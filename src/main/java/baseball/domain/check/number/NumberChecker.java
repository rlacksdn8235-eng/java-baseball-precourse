package baseball.domain.check.number;

import baseball.domain.check.Check;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class NumberChecker implements Check<Void> {
    @Override
    public Void check(String inputNumber) {
        if (isNotNumber(inputNumber) || isNotCorrectLength(inputNumber) || isDuplicate(inputNumber)) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
        return null;
    }

    private boolean isNotNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private boolean isNotCorrectLength(String inputNumber) {
        return inputNumber.length() != 3;
    }

    private boolean isDuplicate(String inputNumber) {
        Set<String> inputNumbers = new HashSet<>();
        Collections.addAll(inputNumbers, inputNumber.split(""));
        return inputNumbers.size() != 3;
    }
}
