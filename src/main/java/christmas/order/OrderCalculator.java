package christmas.order;

import christmas.menu.Menu;
import christmas.promotion.Promotion;

import java.util.Map;

public class OrderCalculator {

    public int calculateTotalPrice(Map<Menu, Integer> orders) {
        int totalPrice = 0;
        for (Map.Entry<Menu, Integer> order : orders.entrySet()) {
            int price = order.getKey().getPrice();
            int count = order.getValue();
            totalPrice += price * count;
        }
        return totalPrice;
    }

    public int calculateTotalDiscountAmount(Map<Promotion, Integer> promotionDetails) {
        int totalDiscountAmount = 0;
        for (int amount : promotionDetails.values()) {
            totalDiscountAmount += amount;
        }
        return totalDiscountAmount;
    }

    public int calculateTotalPriceAfterDiscount(int totalPrice, int totalDiscountAmount, Map<Menu, Integer> giftMenus) {
        int giftPrice = 0;
        for (Map.Entry<Menu, Integer> giftMenu : giftMenus.entrySet()) {
            Menu menu = giftMenu.getKey();
            int count = giftMenu.getValue();
            giftPrice += menu.getPrice() * count;
        }

        return totalPrice - totalDiscountAmount + giftPrice;
    }
}
