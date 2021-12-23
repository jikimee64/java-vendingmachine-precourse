package vendingmachine.domain;

import java.util.Collections;
import java.util.Map;
import vendingmachine.domain.strategy.CoinGenerate;
import vendingmachine.exception.ExceptionMessage;

public class Coins {

    private static final Integer coinsEnumSize = Coin.values().length;

    private final CoinGenerate coinGenerate;
    private Map<Coin, Integer> coinMap;

    public Coins(CoinGenerate coinGenerate) {
        this.coinGenerate = coinGenerate;
    }

    public Map<Coin, Integer> getCoinMap() {
        return Collections.unmodifiableMap(coinMap);
    }

    public Map<Coin, Integer> generateCoins(final int machinePrice) {
        Price price = new Price(machinePrice);

        if(!price.greaterThanZeroMoney()){
            throw new IllegalArgumentException(ExceptionMessage.NOT_ZERO.getMessage());
        }

        this.coinMap = coinGenerate.generateCoins(price);
        return coinMap;
    }

}