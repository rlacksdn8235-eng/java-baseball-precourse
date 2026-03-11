package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

    public static class BaseBall {
        private int[] strikeNumber = new int[3];

        private static boolean checkNumber(String number) {
            return true;
        }

        // 생성시 1~9 랜덤 생성해서 집어넣음
        public BaseBall() {
            this.strikeNumber[0] = Randoms.pickNumberInRange(1, 9);
            this.strikeNumber[1] = Randoms.pickNumberInRange(1, 9);
            this.strikeNumber[2] = Randoms.pickNumberInRange(1, 9);
        }
    }


    public static void main(String[] args) {
        // 숫자 3개 생성
        BaseBall baseBall = new BaseBall();
        int inputNumber = 0;
        // 숫자 입력
        try{
            System.out.print("숫자를 입력해주세요 : ");
            inputNumber = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            return;
        }
        System.out.println(inputNumber);



    }
}
