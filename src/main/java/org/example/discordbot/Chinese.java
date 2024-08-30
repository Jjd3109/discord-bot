package org.example.discordbot;

public enum Chinese {
    DIM_SUM("딤섬"),
    SWEET_AND_SOUR_PORK("탕수육"),
    CHOW_MEIN("짜장면"),
    HOT_POT("훠궈"),
    MAPO_TOFU("마파두부"),
    CHOW_MEIN2("짬뽕"),
    CHOW_MEIN3("졸라 맛있는 마라탕"),
    FRIED_RICE("볶음밥");

    private final String description;

    Chinese(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Menu의 모든 항목을 배열로 가져오기
    public static Chinese[] getMenus() {
        return Chinese.values();
    }
}
