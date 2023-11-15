package christmas.domain.order;

import java.util.Arrays;
import java.util.Objects;

import static christmas.util.ChristmasEventException.NOT_VALID_ORDER;

public enum Menu {

    BUTTON_MUSHROOM_SOUP("양송이수프", MenuCategory.APPETIZER, 6_000),
    TAPAS("타파스", MenuCategory.APPETIZER, 5_500),
    CAESAR_SALAD("시저샐러드", MenuCategory.APPETIZER, 8_000),

    T_BONE_STEAK("티본스테이크", MenuCategory.MAIN, 55_000),
    BARBECUE_RIBS("바비큐립", MenuCategory.MAIN, 54_000),
    SEAFOOD_PASTA("해산물파스타", MenuCategory.MAIN, 35_000),
    CHRISTMAS_PASTA("크리스마스파스타", MenuCategory.MAIN, 25_000),

    CHOCOLATE_CAKE("초코케이크", MenuCategory.DESSERT, 15_000),
    ICE_CREAM("아이스크림", MenuCategory.DESSERT, 5_000),

    ZERO_COLA("제로콜라", MenuCategory.DRINK, 3_000),
    RED_WINE("레드와인", MenuCategory.DRINK, 60_000),
    CHAMPAGNE("샴페인", MenuCategory.DRINK, 25_000);


    private final String name;
    private final MenuCategory category;
    private final int price;

    Menu(String name, MenuCategory category, int price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public static Menu from(String name) {
        return Arrays.stream(values())
                .filter(it -> Objects.equals(it.name, name))
                .findFirst()
                .orElseThrow(NOT_VALID_ORDER::create);
    }

    public String getName() {
        return this.name;
    }

    public MenuCategory getCategory() {
        return this.category;
    }

    public int getPrice() {
        return this.price;
    }
}
