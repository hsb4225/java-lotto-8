package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> numberList = new ArrayList<>(numbers);
        sortNumbers(numberList);
        this.numbers = List.copyOf(numberList);
    }


    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i).equals(numbers.get(j))) {
                    throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되어선 안됩니다.");
                }
            }
        }
        for (int n : numbers) {
            if (n < 1 || n > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    private void sortNumbers(List<Integer> numbers) {
        int size = numbers.size();
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (numbers.get(j) > numbers.get(j + 1)) {
                    int temp = numbers.get(j);
                    numbers.set(j, numbers.get(j + 1));
                    numbers.set(j + 1, temp);
                }
            }
        }
    }


    public List<Integer> getNumbers() {
        return numbers;
    }


    public int countMatch(Lotto other) {
        int cnt = 0;
        for (Integer n : numbers) {
            if (other.numbers.contains(n)) cnt++;
        }
        return cnt;
    }


    public boolean contains(int number) {
        for (int n : numbers) {
            if (n == number) {
                return true;
            }
        }
        return false;
    }


    @Override
    public String toString() {
        return numbers.toString();
    }
}
