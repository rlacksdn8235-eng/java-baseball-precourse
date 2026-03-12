package baseball.domain.check.command;

import baseball.domain.check.Check;
import camp.nextstep.edu.missionutils.Console;

public class CommandChecker implements Check<Void> {
    @Override
    public Void check(String command) {
        if (!command.equals("1") && !command.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
        return null;
    }
}
