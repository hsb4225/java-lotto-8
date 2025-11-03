package lotto;

import java.util.List;

public class Output {

    public void printLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(lotto);
        }
    }

    public void printResult(Result result) {
        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (Rank rank : Rank.values()) {
            if (rank == Rank.MISS) continue;

            String bonusText = "";
            int matchCount = rank.getMatchPoint();

            if (rank == Rank.SECOND) {
                bonusText = ", 보너스 볼 일치";
                matchCount = 5;
            }

            System.out.printf("%d개 일치%s (%,d원) - %d개%n",
                    matchCount, bonusText, rank.getPrize(), result.getCount(rank));
        }

        long totalPrize = result.getTotalPrize();
        int purchaseMoney = result.getPurchaseMoney();
        double rate = (double) totalPrize / purchaseMoney * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rate);
    }
}
