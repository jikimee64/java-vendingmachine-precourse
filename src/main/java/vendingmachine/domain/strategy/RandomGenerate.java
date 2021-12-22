package vendingmachine.domain.strategy;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import java.util.TreeMap;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Price;

public class RandomGenerate implements CoinGenerate {

    private static final Integer coinsEnumSize = Coin.values().length;
    private static final Integer START_RANGE = 0;

    Map<Coin, Integer> coinMap = new TreeMap<>();

    @Override
    public Map<Coin, Integer> generateCoins(Price price) {
        setCoinsMap(price);
        return coinMap;
    }

    private void setCoinsMap(final Price price) {
        Price resultPrice = price;
        for (int i = 0; i < coinsEnumSize; i++) {
            Coin coin = Coin.values()[i];
            int mod = resultPrice.getQuotient(coin);

            if (i == coinsEnumSize - 1) {
                this.coinMap.put(coin, mod);
            }

            if (i != coinsEnumSize - 1) {
                resultPrice = setCoinMap(mod, resultPrice, coin);
            }
        }
    }

    private Price setCoinMap(int mod, Price price, Coin coin) {
        int randomNumber = Randoms.pickNumberInRange(START_RANGE, mod);
        this.coinMap.put(coin, randomNumber);
        return price.minusPrice(randomNumber, coin);
    }

}