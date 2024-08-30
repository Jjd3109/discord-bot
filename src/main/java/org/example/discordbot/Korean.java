package org.example.discordbot;

public enum Korean {
    KOREAN_BBQ("콩나물국밥"),
    BULGOGI("불고기"),
    KIMCHI_STEW("김치찌개"),
    TTEOKBOKKI("떡볶이"),
    KOREAN_FRIED_CHICKEN("치킨"),
    KOREAN_PICKLES("김치찌개"),
    KOREAN_PICKLES1("김치찜"),
    KOREAN_PICKLES2("제육덮밥"),
    KOREAN_PICKLES3("분식"),
    KOREAN_PICKLES4("국밥"),
    KOREAN_PICKLES5("돼지국밥"),
    KOREAN_PICKLES6("매운국밥"),
    KOREAN_PICKLES7("요아정"),
    FastFood("햄버거");

    private final String description;

    Korean(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Menu의 모든 항목을 배열로 가져오기
    public static Korean[] getMenus() {
        return Korean.values();
    }
}
