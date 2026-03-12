package baseball.domain.check;

public interface Check<T> {
    T check(String inputNumber);
}
