package christmas;

import christmas.menu.Menu;

import java.util.HashMap;
import java.util.Map;

public class PromotionManager {

    public Map<Menu, Integer> getGiftMenus(int totalPrice) {
        Map<Menu, Integer> giftMenus = new HashMap<>();
        if (totalPrice >= 120000) {
            giftMenus.put(Menu.CHAMPAGNE, 1);
        }
        return giftMenus;
    }
}
