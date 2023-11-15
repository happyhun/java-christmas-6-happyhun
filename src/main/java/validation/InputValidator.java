package validation;

import christmas.menu.Menu;
import christmas.menu.MenuType;

import java.util.*;

public class InputValidator {

    public static int getValidDate(String input) {
        int date;
        try {
            date = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        if (date < 1 || date > 31) {
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.");
        }

        return date;
    }

    public static Map<Menu, Integer> getValidOrders(String input) {
        Map<Menu, Integer> orders = new HashMap<>();

        for (String order : input.split(",")) {
            StringTokenizer tokenizer = new StringTokenizer(order, "-");
            try {
                Menu menu = getValidMenu(tokenizer.nextToken());
                Integer count = getValidCount(tokenizer.nextToken());
                storeOrder(menu, count, orders);
                validateOrders(orders);
            } catch (NoSuchElementException | IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.");
            }
        }

        return orders;
    }

    private static void storeOrder(Menu menu, Integer count, Map<Menu, Integer> orders) {
        if (orders.containsKey(menu)) {
            throw new IllegalArgumentException();
        }
        orders.put(menu, count);
    }

    private static Menu getValidMenu(String input) {
        Optional<Menu> optionalMenu = Menu.findByName(input);
        if (optionalMenu.isEmpty()) {
            throw new IllegalArgumentException();
        }

        return optionalMenu.get();
    }

    private static Integer getValidCount(String input) {
        int count;
        try {
            count = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        if (count < 1) {
            throw new IllegalArgumentException();
        }

        return count;
    }

    private static void validateOrders(Map<Menu, Integer> orders) {
        boolean isValid = false;
        int totalCount = 0;
        for (Map.Entry<Menu, Integer> order : orders.entrySet()) {
            if (order.getKey().getType() != MenuType.DRINK) {
                isValid = true;
            }
            totalCount += order.getValue();
        }
        if (!isValid) {
            throw new IllegalArgumentException();
        }
        if (totalCount > 20) {
            throw new IllegalArgumentException();
        }
    }
}
