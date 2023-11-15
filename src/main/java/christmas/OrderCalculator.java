package christmas;

import java.util.Map;

public class OrderCalculator {

    public int calculateTotalPrice(Map<Menu, Integer> orders) {
        int totalPrice = 0;
        for (Map.Entry<Menu, Integer> order: orders.entrySet()) {
            int price = order.getKey().getPrice();
            int count = order.getValue();
            totalPrice += price * count;
        }
        return totalPrice;
    }
}
