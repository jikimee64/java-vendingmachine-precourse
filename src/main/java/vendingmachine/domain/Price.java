package vendingmachine.domain;

import java.util.Objects;

public class Price {

    private static int ZERO = 0;

    private int price;

    public Price(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public boolean greaterThanZeroMoney(){
        return this.price > ZERO;
    }

    public int getQuotient(Coin coin){
        if(this.price < coin.getPrice()){
            return 0;
        }

        return this.price / coin.getPrice();
    }

    public Price plusPrice(int price){
        return new Price(this.price + price);
    }

    public Price minusPrice(int price){
        return new Price(this.price - price);
    }

    //TODO: 메소드명 변경
    public Price minusPrice(int randomNumber, Coin coin){
        return new Price(this.price - (randomNumber * coin.getPrice()));
    }

    public boolean hasPriceLessThanProductPrice(Price hasPrice){
        if(this.price > hasPrice.getPrice()){
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Price price1 = (Price) o;
        return price == price1.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}