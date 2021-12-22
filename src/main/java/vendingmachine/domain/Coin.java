package vendingmachine.domain;

public enum Coin {
    COIN_500(new Price(500)),
    COIN_100(new Price(100)),
    COIN_50(new Price(50)),
    COIN_10(new Price(10));

    private final Price price;

    Coin(final Price price) {
        this.price = price;
    }

    public int getPrice() {
        return price.getPrice();
    }
}

