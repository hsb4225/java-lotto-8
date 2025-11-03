package lotto;

import java.util.List;

public class Result {

    private final int[] counts = new int[Rank.values().length];
    private long totalPrize = 0L;


    public Result(List<Lotto> lottoList, InputLotto lotto) {
        for (Lotto l : lottoList) {
            match(l, lotto);
        }
    }


    private void match(Lotto l, InputLotto lotto) {
        int match = l.countMatch(lotto.getLottoNumbers());
        boolean bonus = l.contains(lotto.getBonusNumber());
        Rank rank = Rank.valueOf(match, bonus);

        counts[rank.ordinal()]++;
        totalPrize += rank.getPrize();
    }


    public int getCount(Rank rank) {
        return counts[rank.ordinal()];
    }


    public long getTotalPrize() {
        return totalPrize;
    }

    public void printResult() {
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;
            System.out.printf("%s - %d개 (상금 %,d원)%n",
                    rank.name(), getCount(rank), rank.getPrize());
        }
        System.out.printf("총 상금: %,d원%n", totalPrize);
    }

}