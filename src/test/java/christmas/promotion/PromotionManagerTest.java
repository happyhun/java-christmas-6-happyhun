package christmas.promotion;


import christmas.menu.Menu;
import christmas.menu.MenuType;
import christmas.promotion.PromotionManager;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static christmas.promotion.Badge.*;
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

    @Test
    void 평일에는_디저트_할인을_적용한다() {
        int date = 4;
        MenuType menuType = MenuType.DESSERT;

        assertThat(promotionManager.getWeekdayDiscountAmount(menuType, date)).isEqualTo(2023);
    }

    @Test
    void 주말에는_디저트_할인을_적용하지_않는다() {
        int date = 1;
        MenuType menuType = MenuType.DESSERT;

        assertThat(promotionManager.getWeekdayDiscountAmount(menuType, date)).isEqualTo(0);
    }

    @Test
    void 주말에는_메인_할인을_적용한다() {
        int date = 1;
        MenuType menuType = MenuType.MAIN;

        assertThat(promotionManager.getWeekendDiscountAmount(menuType, date)).isEqualTo(2023);
    }

    @Test
    void 평일에는_메인_할인을_적용하지_않는다() {
        int date = 4;
        MenuType menuType = MenuType.MAIN;

        assertThat(promotionManager.getWeekendDiscountAmount(menuType, date)).isEqualTo(0);
    }

    @Test
    void 이벤트_달력에_별이_있으면_특별_할인을_적용한다() {
        List<Integer> spcialDates = List.of(1, 2, 3);
        int date = 2;

        assertThat(promotionManager.getSpecialDiscountAmount(spcialDates, date)).isEqualTo(1000);
    }

    @Test
    void 총혜택_금액이_2만원_이상이면_산타_배지를_받는다() {
        int totalDiscountAmount = 20000;
        assertThat(promotionManager.getBadge(totalDiscountAmount).get()).isEqualTo(SANTA);
    }

    @Test
    void 총혜택_금액이_1만원_이상이면_트리_배지를_받는다() {
        int totalDiscountAmount = 10000;
        assertThat(promotionManager.getBadge(totalDiscountAmount).get()).isEqualTo(TREE);
    }

    @Test
    void 총혜택_금액이_5천원_이상이면_별_배지를_받는다() {
        int totalDiscountAmount = 5000;
        assertThat(promotionManager.getBadge(totalDiscountAmount).get()).isEqualTo(STAR);
    }

    @Test
    void 총혜택_금액이_5천원_미만이면_배지를_못받는다() {
        int totalDiscountAmount = 4000;
        assertThat(promotionManager.getBadge(totalDiscountAmount)).isEmpty();
    }
}