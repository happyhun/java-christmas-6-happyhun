package christmas;

import christmas.menu.Menu;

import java.util.Map;
import java.util.Optional;

public record OrderResult(Map<Menu, Integer> orders, int totalPrice, Map<Menu, Integer> giftMenus,
                          Map<Promotion, Integer> promotionDetails, int totalDiscountAmount,
                          Optional<Badge> optionalBadge) {
}
