package christmas;

import christmas.menu.Menu;
import christmas.menu.MenuType;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import static christmas.Promotion.*;

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

    public int getWeekdayDiscountAmount(MenuType menuType, int date) {
        if (menuType != MenuType.DESSERT) {
            return 0;
        }

        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek day = localDate.getDayOfWeek();

        if (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY) {
            return 0;
        }

        return WEEKDAY_DISCOUNT.getDiscount();
    }

    public int getWeekendDiscountAmount(MenuType menuType, int date) {
        if (menuType != MenuType.MAIN) {
            return 0;
        }

        LocalDate localDate = LocalDate.of(2023, 12, date);
        DayOfWeek day = localDate.getDayOfWeek();

        if (day == DayOfWeek.FRIDAY || day == DayOfWeek.SATURDAY) {
            return WEEKEND_DISCOUNT.getDiscount();
        }

        return 0;
    }
}
