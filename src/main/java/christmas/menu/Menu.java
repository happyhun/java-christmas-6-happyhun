package christmas.menu;

import java.util.Optional;

import static christmas.menu.MenuType.*;

public enum Menu {
    BUTTON_MUSHROOM_SOUP("양송이수프", APPETIZER, 6000),
    TAPAS("타파스", APPETIZER, 5500),
    CAESAR_SALAD("시저샐러드", APPETIZER, 8000),
    T_BONE_STEAK("티본스테이크", MAIN, 55000),
    BBQ_RIBS("바비큐립", MAIN, 54000),
    SEAFOOD_PASTA("해산물파스타", MAIN, 35000),
    CHRISTMAS_PASTA("크리스마스파스타", MAIN, 25000),
    CHOCOLATE_CAKE("초코케이크", DESSERT, 15000),
    ICE_CREAM("아이스크림", DESSERT, 5000),
    COKE_ZERO("제로콜라", DRINK, 3000),
    RED_WINE("레드와인", DRINK, 60000),
    CHAMPAGNE("샴페인", DRINK, 25000);

    private final String name;
    private final MenuType type;
    private final int price;

    Menu(String name, MenuType type, int price) {
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public MenuType getType() {
        return type;
    }

    public int getPrice() {
        return price;
    }

    public static Optional<Menu> findByName(String name) {
        for (Menu menu : Menu.values()) {
            if (menu.getName().equals(name)) {
                return Optional.of(menu);
            }
        }
        return Optional.empty();
    }
}
