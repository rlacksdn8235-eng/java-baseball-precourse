package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        String command = "1";

        while (command.equals("1")) {
            play();
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            command = Console.readLine();
            validateCommand(command);
        }
    }

    public static void play() {
        BaseBall baseBall = new BaseBall();

        while (baseBall.getStrike() < 3) {
            baseBall.resetBallStrike();
            // 숫자 입력
            System.out.print("숫자를 입력해주세요 : ");
            String inputNumbers = Console.readLine();
            validateInputNumber(inputNumbers);

            // 숫자 검증
            System.out.println(baseBall.checkNumber(inputNumbers));
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private static void validateCommand(String command) {
        if (!command.equals("1") && !command.equals("2")) {
            throw new IllegalArgumentException("1 또는 2만 입력 가능합니다.");
        }
    }

    public static void validateInputNumber(String inputNumber) {
        if (isNotNumber(inputNumber) || isNotCorrectLength(inputNumber) || isDuplicate(inputNumber)) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    private static boolean isNotNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    private static boolean isNotCorrectLength(String inputNumber) {
        return inputNumber.length() != 3;
    }

    private static boolean isDuplicate(String inputNumber) {
        Set<String> inputNumbers = new HashSet<>();
        Collections.addAll(inputNumbers, inputNumber.split(""));
        return inputNumbers.size() != 3;
    }
}
