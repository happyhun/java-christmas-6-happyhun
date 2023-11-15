package christmas;

import static christmas.MenuType.*;

public enum Menu {
    BUTTON_MUSHROOM_SOUP(APPETIZER, 6000),
    TAPAS(APPETIZER, 5500),
    CAESAR_SALAD(APPETIZER, 8000),
    T_BONE_STEAK(MAIN, 55000),
    BBQ_RIBS(MAIN, 54000),
    SEAFOOD_PASTA(MAIN, 35000),
    CHRISTMAS_PASTA(MAIN, 25000),
    CHOCOLATE_CAKE(DESSERT, 15000),
    ICE_CREAM(DESSERT, 5000),
    COKE_ZERO(DRINK, 3000),
    RED_WINE(DRINK, 60000),
    CHAMPAGNE(DRINK, 25000);

    private final MenuType type;
    private final int price;

    private Menu(MenuType type, int price) {
        this.type = type;
        this.price = price;
    }

    public MenuType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }
}
