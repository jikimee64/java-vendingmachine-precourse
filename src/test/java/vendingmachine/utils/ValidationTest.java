package vendingmachine.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

class ValidationTest {

    @Test
    void 상품가격검사_성공(){
        //given
        int price = 500;

        //when
        int validtedPrice = Validation.validPriceGreaterThanAndUnit(price);

        //then
        assertThat(validtedPrice).isEqualTo(price);
    }

    @Test
    void 상품가격검사_100원미만일경우_예외(){
        //given
        int price = 50;

        //when & then
        assertThatThrownBy(() -> {
            Validation.validPriceGreaterThanAndUnit(price);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 100원보다 큰 금액을 입력해주세요.");
    }

    @Test
    void 상품가격검사_10원단위가_아닐경우_예외(){
        //given
        int price = 155;

        //when & then
        assertThatThrownBy(() -> {
            Validation.validPriceGreaterThanAndUnit(price);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("[ERROR] 10원단위로 입력해주세요.");
    }

}