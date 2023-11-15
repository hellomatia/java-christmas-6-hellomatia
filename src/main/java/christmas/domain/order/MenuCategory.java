package christmas.domain.order;

import java.util.List;

public enum MenuCategory {

    APPETIZER("에피타이저", List.of("양송이수프", "타파스", "시저샐러드")),
    MAIN("메인", List.of("티본스테이크", "바비큐립", "해산물파스타", "크리스마스파스트")),
    DESSERT("디저트", List.of("초코케이크", "아이스크림")),
    DRINK("음료", List.of("제로콜라", "레드와인", "샴페인"));

    private final String category;
    private final List<String> menus;

    MenuCategory(String category, List<String> menus) {
        this.category = category;
        this.menus = menus;
    }
}
