package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class Application {

    public static class BaseBall {
        private int ball = 0;
        private int strike = 0;
        private final List<Integer> strikeNumbers = new ArrayList<>();

        // 생성시 1~9 랜덤 생성해서 집어넣음
        public BaseBall() {
            while (strikeNumbers.size() < 3) {
                addIsNotExists();
            }
        }

        // 중복이 아니면 숫자 추가
        public void addIsNotExists() {
            int randomNumber = Randoms.pickNumberInRange(1,9);
            if (!strikeNumbers.contains(randomNumber)) {
                this.strikeNumbers.add(randomNumber);
            }
        }

        // 숫자 판별 로직
        private String checkNumber(String inputNumbers) {
            String answer = "";
            for (int i = 0 ; i < 3 ; i++) {
                isStrikeOrBall(i, inputNumbers);
            }
            if (ball == 0 && strike == 0) {
                return "낫싱";
            }
            if (strike == 0) {
                return ball + "볼";
            }
            if (ball == 0) {
                return strike + "스트라이크";
            }
            return ball + "볼 " + strike + "스트라이크";
        }

        // 공 판별 로직
        private void isStrikeOrBall(int index, String inputNumbers) {
            int[] inputNumber = Arrays.stream(inputNumbers.split(""))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (strikeNumbers.get(index) == inputNumber[index]) {
                strike++;
            }
            else if (strikeNumbers.contains(inputNumber[index])) {
                ball++;
            }
        }

        private void resetBallStrike() {
            this.ball = 0;
            this.strike = 0;
        }

    }

    public static void checkIsCorrectNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    public static void restart(String inputNumber) {
        if (inputNumber.equals("1")) {
            BASEBALL = new BaseBall();
            BASEBALL.resetBallStrike();
        }
    }

    // 숫자 3개 생성
    static BaseBall BASEBALL = new BaseBall();

    public static void main(String[] args) {
        String inputNumbers = "";

        while (BASEBALL.strike != 3) {
            BASEBALL.resetBallStrike();
            // 숫자 입력
            System.out.print("숫자를 입력해주세요 : ");
            inputNumbers = Console.readLine();
            checkIsCorrectNumber(inputNumbers);

            // 숫자 검증
            System.out.println(BASEBALL.checkNumber(inputNumbers));
            if (BASEBALL.strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                restart(Console.readLine());
            }
        }




    }
}
