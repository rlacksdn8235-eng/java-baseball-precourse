package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BaseBall {
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
    public String checkNumber(String inputNumbers) {
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

    public void resetBallStrike() {
        this.ball = 0;
        this.strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
