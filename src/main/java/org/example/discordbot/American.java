package org.example.discordbot;

public enum American {
    BURGER("햄버거"),
    HOT_DOG("핫도그"),
    PIZZA("피자"),
    FRIES("감튀"),
    BBQ("바베큐"),
    TACO("타코"),
    RIBS("립"),
    PILAFE("필라프"),
    PILAFE2("까르보나라");

    private final String description;

    American(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Menu의 모든 항목을 배열로 가져오기
    public static American[] getMenus() {
        return American.values();
    }
}
