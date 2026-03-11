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

        // 스트라이크 판별 로직(숫자가 서로 같을때)
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

        // 볼 판별 로직(숫자의 위치가 다르지만 같은게 존재할때)

    }

    public static void checkIsCorrectNumber(String inputNumber) {
        try {
            Integer.parseInt(inputNumber);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("잘못된 값 입력");
        }
    }

    public static void main(String[] args) {
        String inputNumbers = "";

        // 숫자 3개 생성
        BaseBall baseBall = new BaseBall();

        // 숫자 입력
        System.out.print("숫자를 입력해주세요 : ");
        inputNumbers = Console.readLine();
        checkIsCorrectNumber(inputNumbers);

        // 숫자 검증
        System.out.println(baseBall.checkNumber(inputNumbers));




    }
}
