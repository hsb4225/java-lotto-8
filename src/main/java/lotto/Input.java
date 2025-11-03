package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public int readPurchaseMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String line = Console.readLine().trim();
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자 형식의 금액을 입력해야 합니다.");
            }
        }
    }

    public Lotto readWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String line = Console.readLine();
                String[] parts = line.split(",");
                List<Integer> nums = new ArrayList<>();
                for (String part : parts) {
                    part = part.trim();
                    int number = Integer.parseInt(part);
                    nums.add(number);
                }
                return new Lotto(nums);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 당첨 번호 입력이 잘못되었습니다.");
            }
        }
    }

    public int readBonusNumber(Lotto winning) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String line = Console.readLine().trim();
                int bonus = Integer.parseInt(line);
                if (bonus < 1 || bonus > 45) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
                }
                if (winning.contains(bonus)) {
                    throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
                }
                return bonus;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 보너스 번호는 숫자여야 합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public InputLotto readLotto() {
        Lotto winningNumbers = readWinningNumbers();
        int bonusNumber = readBonusNumber(winningNumbers);
        return new InputLotto(winningNumbers, bonusNumber);
    }
}
