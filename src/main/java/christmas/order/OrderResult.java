package christmas.order;

import christmas.menu.Menu;
import christmas.promotion.Badge;
import christmas.promotion.Promotion;

import java.util.Map;
import java.util.Optional;

public record OrderResult(int date, Map<Menu, Integer> orders, int totalPrice, Map<Menu, Integer> giftMenus,
                          Map<Promotion, Integer> promotionDetails, int totalDiscountAmount,
                          int totalPriceAfterDiscount,
                          Optional<Badge> optionalBadge) {
}
