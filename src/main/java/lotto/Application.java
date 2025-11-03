package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        Input input = new Input();
        Output output = new Output();
        CreateLotto creator = new CreateLotto();

        int purchaseMoney = input.readPurchaseMoney();
        List<Lotto> myLottos = creator.lottoList(purchaseMoney);

        output.printLottos(myLottos);
        InputLotto winningLotto = input.readLotto();

        Result result = new Result(myLottos, winningLotto, purchaseMoney);
        output.printResult(result);

    }
}
