package baseball.domain.user;

import baseball.domain.check.number.NumberChecker;
import camp.nextstep.edu.missionutils.Console;

public class User {
    private final NumberChecker checkNumber;
    // 행동
    public String inputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
        String inputNumbers = Console.readLine();
        checkNumber.check(inputNumbers);
        return inputNumbers;
    }

    public User(NumberChecker checkNumber) {
        this.checkNumber = checkNumber;
    }
}
