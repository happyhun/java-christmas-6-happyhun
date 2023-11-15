package christmas;

import christmas.menu.Menu;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static christmas.menu.Menu.BUTTON_MUSHROOM_SOUP;
import static org.assertj.core.api.Assertions.assertThat;

class OrderCalculatorTest {

    OrderCalculator orderCalculator = new OrderCalculator();

    @Test
    void 총주문_금액_계산() {
        Map<Menu, Integer> orders = new HashMap<>();
        orders.put(BUTTON_MUSHROOM_SOUP, 2);

        assertThat(orderCalculator.calculateTotalPrice(orders)).isEqualTo(12000);
    }

    @Test
    void 총할인_금액_계산() {
        Map<Promotion, Integer> promotionDetails = new HashMap<>();
        promotionDetails.put(Promotion.CHRISTMAS_DDAY_DISCOUNT, 1100);
        promotionDetails.put(Promotion.SPECIAL_DISCOUNT, 2000);

        assertThat(orderCalculator.calculateTotalDiscountAmount(promotionDetails)).isEqualTo(3100);
    }

}