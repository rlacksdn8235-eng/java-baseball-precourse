package baseball.domain.computer;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    // 행동에 필요한 상태
    private final List<Integer> answerNumbers = new ArrayList<>();
    // 행동
    public void createAnswer() {
        answerNumbers.clear();
        while (answerNumbers.size() < 3) {
            addIsNotExists();
        }
    }

    public Computer() {
    }

    // 중복이 아니면 숫자 추가
    private void addIsNotExists() {
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if (!answerNumbers.contains(randomNumber)) {
            this.answerNumbers.add(randomNumber);
        }
    }

    public List<Integer> getAnswerNumbers() {
        return answerNumbers;
    }
}
