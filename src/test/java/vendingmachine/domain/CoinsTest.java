package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Map;
import java.util.Map.Entry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import vendingmachine.domain.strategy.RandomGenerate;

class CoinsTest {

    Coins coins;

    @BeforeEach
    void init(){
        coins = new Coins(new RandomGenerate());
    }

    @ParameterizedTest
    @ValueSource(ints = {450, 600, 1000})
    void generateCoins(int machinePrice) {
        int sum = 0;
        Map<Coin, Integer> coinMap = coins.generateCoins(machinePrice);

        for (Entry<Coin, Integer> entry : coinMap.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }

        assertThat(sum).isEqualTo(machinePrice);
    }

}