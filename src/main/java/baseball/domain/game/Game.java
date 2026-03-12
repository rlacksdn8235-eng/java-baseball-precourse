package baseball.domain.game;

import baseball.domain.ball.Ball;
import baseball.domain.computer.Computer;
import baseball.domain.user.User;

public class Game {
    private final User user;
    private final Ball ball;
    private final Computer computer;

    public Game(User user, Ball ball, Computer computer) {
        this.user = user;
        this.ball = ball;
        this.computer = computer;
    }

    public void play() {
        ball.resetBallStrike();
        computer.createAnswer();
        while (ball.getStrike() < 3) {
            ball.resetBallStrike();
            // 숫자 입력
            String inputNumber = user.inputNumber();
            // 볼 검증
            ball.printResult(inputNumber);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
