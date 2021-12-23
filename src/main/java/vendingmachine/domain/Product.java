package vendingmachine.domain;

public class Product {

    private Name name;
    private Price price;
    private int amount;

    public Product(String name, int price, int amount) {
        this.name = new Name(name);
        this.price = new Price(price);
        this.amount = amount;
    }

}