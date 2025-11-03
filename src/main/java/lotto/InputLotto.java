package lotto;

public class InputLotto {

    private final Lotto lottoNumbers;
    private final int bonusNumber;


    public InputLotto(Lotto lottoNumbers, int bonusNumber) {
        validateBonus(lottoNumbers, bonusNumber);
        this.lottoNumbers = lottoNumbers;
        this.bonusNumber = bonusNumber;
    }


    private void validateBonus(Lotto lottoNumbers, int bonusNumber) {
        if (!(bonusNumber >= 1 && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        for (int number : lottoNumbers.getNumbers()) {
            if(number == bonusNumber) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }

        }
    }


    public Lotto getLottoNumbers() {
        return lottoNumbers;
    }


    public int getBonusNumber() {
        return bonusNumber;
    }
}
