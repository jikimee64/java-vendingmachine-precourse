package vendingmachine.domain.strategy;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Price;

public interface CoinGenerate {
    Map<Coin, Integer> generateCoins(Price price);
}