package christmas;


import christmas.menu.Menu;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class PromotionManagerTest {

    PromotionManager promotionManager = new PromotionManager();

    @Test
    void 총주문_금액이_12만원_이상이면_증정_메뉴를_준다() {
        int totalPrice = 120000;
        Map<Menu, Integer> giftMenus = promotionManager.getGiftMenus(totalPrice);
        assertThat(giftMenus.get(Menu.CHAMPAGNE)).isEqualTo(1);
    }

    @Test
    void 이벤트_기간에_크리스마스_디데이_할인을_적용한다() {
        int date = 25;
        assertThat(promotionManager.getChristmasDdayDiscountAmount(date)).isEqualTo(3400);
    }

    @Test
    void 이벤트_기간이_지나면_크리스마스_디데이_할인을_적용하지_않는다() {
        int date = 26;
        assertThat(promotionManager.getChristmasDdayDiscountAmount(date)).isEqualTo(0);
    }
}