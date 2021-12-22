package vendingmachine.domain;

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

    public Price minusPrice(int randomNumber, Coin coin){
        return new Price(this.price - (randomNumber * coin.getPrice()));
    }

}