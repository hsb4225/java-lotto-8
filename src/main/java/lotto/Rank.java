package lotto;

public enum Rank {
    FIRST(6, false, 2000000000L),
    SECOND(5, true, 30000000L),
    THIRD(5, false, 1500000L),
    FOURTH(4, false, 50000L),
    FIFTH(3, false, 5000L),
    MISS(0, false, 0L);


    private final int matchPoint;
    private final boolean bonus;
    private final long prize;


    Rank(int matchPoint, boolean bonus, long prize) {
        this.matchPoint = matchPoint;
        this.bonus = bonus;
        this.prize = prize;
    }


    public static Rank valueOf(int matchCount, boolean matchBonus) {
        if (matchCount == 6) return FIRST;
        if (matchCount == 5 && matchBonus) return SECOND;
        if (matchCount == 5) return THIRD;
        if (matchCount == 4) return FOURTH;
        if (matchCount == 3) return FIFTH;
        return MISS;
    }


    public long getPrize() {
        return prize;
    }
}
