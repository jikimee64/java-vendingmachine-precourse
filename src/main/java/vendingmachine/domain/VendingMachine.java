package vendingmachine.domain;

public class VendingMachine {

    private Products products;
    private Coins coins;

    public VendingMachine(Products products, Coins coins) {
        this.products = products;
        this.coins = coins;
    }

}