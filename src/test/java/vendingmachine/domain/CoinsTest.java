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
    void 랜덤_잔돈_생성(int machinePrice) {
        //given
        int sum = 0;

        //when
        Map<Coin, Integer> coinMap = coins.generateCoins(machinePrice);

        for (Entry<Coin, Integer> entry : coinMap.entrySet()) {
            sum += entry.getKey().getPrice() * entry.getValue();
        }

        //then
        assertThat(sum).isEqualTo(machinePrice);
    }

}