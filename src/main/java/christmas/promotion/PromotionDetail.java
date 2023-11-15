package christmas.promotion;

import christmas.menu.Menu;
import christmas.menu.MenuType;
import christmas.order.OrderCalculator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PromotionDetail {

    private final PromotionManager promotionManager = new PromotionManager();
    private final OrderCalculator orderCalculator = new OrderCalculator();

    public Map<Promotion, Integer> getPromotionDetails(Map<Menu, Integer> orders, Map<Menu, Integer> giftMenus, List<Integer> specialDates, int date) {
        Map<Promotion, Integer> promotionDetails = initPromotionDetails();

        setDiscountsForTotalPrice(giftMenus, specialDates, date, promotionDetails);
        setDiscountsForDayOfWeek(orders, date, promotionDetails);

        return promotionDetails;
    }

    private Map<Promotion, Integer> initPromotionDetails() {
        Map<Promotion, Integer> promotionDetails = new HashMap<>();
        for (Promotion promotion : Promotion.values()) {
            promotionDetails.put(promotion, 0);
        }
        return promotionDetails;
    }

    private void setDiscountsForTotalPrice(Map<Menu, Integer> giftMenus, List<Integer> specialDates, int date, Map<Promotion, Integer> promotionDetails) {
        promotionDetails.put(Promotion.GIFT_EVENT, orderCalculator.calculateTotalPrice(giftMenus));
        promotionDetails.put(Promotion.CHRISTMAS_DDAY_DISCOUNT, promotionManager.getChristmasDdayDiscountAmount(date));
        promotionDetails.put(Promotion.SPECIAL_DISCOUNT, promotionManager.getSpecialDiscountAmount(specialDates, date));
    }

    private void setDiscountsForDayOfWeek(Map<Menu, Integer> orders, int date, Map<Promotion, Integer> promotionDetails) {
        int weekdayDiscountAmount = 0;
        int weekendDiscountAmount = 0;

        for (Map.Entry<Menu, Integer> order : orders.entrySet()) {
            MenuType menuType = order.getKey().getType();
            int count = order.getValue();
            weekdayDiscountAmount += promotionManager.getWeekdayDiscountAmount(menuType, date) * count;
            weekendDiscountAmount += promotionManager.getWeekendDiscountAmount(menuType, date) * count;
        }

        promotionDetails.put(Promotion.WEEKDAY_DISCOUNT, weekdayDiscountAmount);
        promotionDetails.put(Promotion.WEEKEND_DISCOUNT, weekendDiscountAmount);
    }
}
