package christmas.promotion;

import christmas.menu.Menu;
import christmas.promotion.Promotion;
import christmas.promotion.PromotionDetail;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PromotionDetailTest {

    PromotionDetail promotionDetail = new PromotionDetail();

    @Test
    void 할인_내역을_구한다() {
        Map<Menu, Integer> orders = new HashMap<>();
        orders.put(Menu.T_BONE_STEAK, 1);
        orders.put(Menu.BBQ_RIBS, 1);
        orders.put(Menu.CHOCOLATE_CAKE, 2);
        orders.put(Menu.COKE_ZERO, 1);

        Map<Menu, Integer> giftMenus = new HashMap<>();
        giftMenus.put(Menu.CHAMPAGNE, 1);

        List<Integer> specialDates = List.of(3);
        int date = 3;

        Map<Promotion, Integer> promotionDetails = promotionDetail.getPromotionDetails(orders, giftMenus, specialDates, date);
        assertThat(promotionDetails.get(Promotion.CHRISTMAS_DDAY_DISCOUNT)).isEqualTo(1200);
        assertThat(promotionDetails.get(Promotion.WEEKDAY_DISCOUNT)).isEqualTo(4046);
        assertThat(promotionDetails.get(Promotion.SPECIAL_DISCOUNT)).isEqualTo(1000);
        assertThat(promotionDetails.get(Promotion.GIFT_EVENT)).isEqualTo(25000);
    }
}