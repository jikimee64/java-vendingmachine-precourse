package vendingmachine.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Objects;
import org.junit.jupiter.api.Test;
import vendingmachine.domain.Product;

class SplitTest {

    @Test
    void 상품입력값_분할후_PRODUCT객체_생성(){
        //given
        String inputProduct = "[콜라,1500,20];[사이다,1000,10]";
        Product savedCola = new Product("콜라", 1500, 20);
        Product savedCider = new Product("사이다", 1000, 10);

        //when
        List<Product> products = Split.getProducts(inputProduct);
        Product cola = products.get(0);
        Product cider = products.get(1);

        //then
        assertThat(Objects.equals(savedCola, cola)).isEqualTo(true);
        assertThat(Objects.equals(savedCider, cider)).isEqualTo(true);
    }

}