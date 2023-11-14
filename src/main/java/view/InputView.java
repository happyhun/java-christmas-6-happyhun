package view;

import camp.nextstep.edu.missionutils.Console;
import validation.InputValidator;

public class InputView {

    public int readDate() {
        int date;
        while (true) {
            System.out.println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)");
            String input = Console.readLine();
            try {
                date = InputValidator.getValidDate(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return date;
    }
}
