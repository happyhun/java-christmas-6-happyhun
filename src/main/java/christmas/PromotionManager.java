package christmas;

import christmas.menu.Menu;

import java.util.HashMap;
import java.util.Map;

import static christmas.Promotion.CHRISTMAS_DDAY_DISCOUNT;

public class PromotionManager {

    public Map<Menu, Integer> getGiftMenus(int totalPrice) {
        Map<Menu, Integer> giftMenus = new HashMap<>();
        if (totalPrice >= 120000) {
            giftMenus.put(Menu.CHAMPAGNE, 1);
        }
        return giftMenus;
    }

    public int getChristmasDdayDiscountAmount(int date) {
        if (date > 25) {
            return 0;
        }
        return CHRISTMAS_DDAY_DISCOUNT.getDiscount() + (date - 1) * 100;
    }
}
