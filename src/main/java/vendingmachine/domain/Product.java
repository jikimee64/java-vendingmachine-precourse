package vendingmachine.domain;

import java.util.Objects;

public class Product {

    private Name name;
    private Price price;
    private int amount;
    private boolean isSoldout = false;

    public Product(String name, int price, int amount) {
        this.name = new Name(name);
        this.price = new Price(price);
        this.amount = amount;
    }

    public Price getPrice() {
        return price;
    }

    public String getProductName() {
        return name.getName();
    }

    public boolean isSameProductName(String productName) {
        return name.isSameName(productName);
    }

    public void minusAmount() {
        this.amount -= 1;
        if(this.amount == 0){
            this.isSoldout = true;
        }
    }

    public boolean hasNonProduct() {
        if (this.isSoldout) {
            return true;
        }
        return false;
    }

    public boolean hasPriceLessThanProductPrice(Price hasPrice){
        return this.price.hasPriceLessThanProductPrice(hasPrice);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(price, product.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }

}