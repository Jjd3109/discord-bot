package org.example.discordbot;

public enum Japan {
    SUSHI("초밥"),
    RAMEN("라멘"),
    TEMPURA("일본식 튀김"),
    SASHIMI("돈부리"),
    YAKITORI("야키토리"),
    UDON("우동"),
    TAKOYAKI("타코야키"),
    OKONOMIYAKI("오코노미야키"),
    KATSUDON("가츠동");

    private final String description;

    Japan(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Menu의 모든 항목을 배열로 가져오기
    public static Japan[] getMenus() {
        return Japan.values();
    }
}
