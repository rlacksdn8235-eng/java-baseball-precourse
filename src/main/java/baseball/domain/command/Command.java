package baseball.domain.command;

import baseball.domain.check.command.CommandChecker;
import camp.nextstep.edu.missionutils.Console;

public class Command {
    private String command = "1";
    private final CommandChecker commandChecker;

    public Command(CommandChecker commandChecker) {
        this.commandChecker = commandChecker;
    }

    public void inputCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        command = Console.readLine();
        commandChecker.check(command);
    }

    public boolean isStart() {
        return command.equals("1");
    }
}
