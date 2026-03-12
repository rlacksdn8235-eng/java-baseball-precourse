package baseball;

import baseball.domain.ball.Ball;
import baseball.domain.check.command.CommandChecker;
import baseball.domain.check.number.NumberChecker;
import baseball.domain.command.Command;
import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.user.User;

public class Application {
    public static void main(String[] args) {
        NumberChecker numberChecker = new NumberChecker();
        Computer computer = new Computer();
        User user = new User(numberChecker);
        Ball ball = new Ball(computer);
        Game game = new Game(user, ball, computer);
        CommandChecker commandChecker = new CommandChecker();
        Command command = new Command(commandChecker);

        do {
            game.play();
            command.inputCommand();
        } while (command.isStart());
    }
}
