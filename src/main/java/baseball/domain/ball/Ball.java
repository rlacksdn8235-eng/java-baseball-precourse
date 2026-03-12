package baseball.domain.ball;

import baseball.domain.computer.Computer;

import java.util.Arrays;
import java.util.List;

public class Ball {
    private int ball = 0;
    private int strike = 0;
    private int[] inputNumber;
    private final Computer computer;

    public Ball(Computer computer) {
        this.computer = computer;
    }

    public void printResult(String inputNumbers) {
        String answer = "";
        inputNumber = Arrays.stream(inputNumbers.split(""))
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> strikeNumbers = computer.getAnswerNumbers();
        for (int i = 0 ; i < 3 ; i++) {
            isStrikeOrBall(i, strikeNumbers);
        }
        if (ball == 0 && strike == 0) {
            answer = "낫싱";
        }
        else if (strike == 0) {
            answer = ball + "볼";
        }
        else if (ball == 0) {
            answer = strike + "스트라이크";
        } else {
            answer = ball + "볼 " + strike + "스트라이크";
        }
        System.out.println(answer);
    }

    private void isStrikeOrBall(int index, List<Integer> strikeNumbers) {
        if (strikeNumbers.get(index) == inputNumber[index]) {
            strike++;
        }
        else if (strikeNumbers.contains(inputNumber[index])) {
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public void resetBallStrike() {
        this.ball = 0;
        this.strike = 0;
    }
}
