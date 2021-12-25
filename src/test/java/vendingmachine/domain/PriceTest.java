package vendingmachine.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PriceTest {

    @Test
    void 몫반환_보유한금액_나누기_단위(){
        //given
        Price price = new Price(1000);

        //when
        int quotient = price.getQuotient(Coin.COIN_100);

        //then
        assertThat(quotient).isEqualTo(10);
    }

    @Test
    void 몫반환_보유한_금액이_특정단위보다_작을경우_0반환(){
        //given
        Price price = new Price(450);

        //when
        int quotient = price.getQuotient(Coin.COIN_500);

        //then
        assertThat(quotient).isEqualTo(0);
    }

    @Test
    void 보유한금액_감소(){
        //given
        Price price = new Price(1000);

        //when
        Price savedPrice = price.minusPrice(5, Coin.COIN_10);

        //then
        assertThat(savedPrice.getPrice()).isEqualTo(950);
    }

}