package christmas.promotion;

import static christmas.menu.Menu.CHAMPAGNE;

public enum Promotion {
    CHRISTMAS_DDAY_DISCOUNT("크리스마스 디데이 할인", 1000),
    WEEKDAY_DISCOUNT("평일 할인", 2023),
    WEEKEND_DISCOUNT("주말 할인", 2023),
    SPECIAL_DISCOUNT("특별 할인", 1000),
    GIFT_EVENT("증정 이벤트", CHAMPAGNE.getPrice());

    private final String name;
    private final int discount;

    Promotion(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }
}
