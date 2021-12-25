package vendingmachine.domain;

import vendingmachine.domain.state.NoCoinState;
import vendingmachine.domain.state.VendcingMachineState;
import vendingmachine.exception.ExceptionMessage;

/**
 * 상태패턴 1. 넣어진 동전 없음 2. 동전 넣음 3. 제품 선택 4. 품절
 */
public class VendingMachine {

    private VendcingMachineState state = new NoCoinState();
    private Products products;
    private Coins coins; //보유한 동전
    private Price hasPrice; //투입 금액

    public VendingMachine(Products products, Coins coins) {
        this.products = products;
        this.coins = coins;
    }

    public void changeState(VendcingMachineState state) {
        this.state = state;
    }

    public void purChaseProduct(final String productName) {
        Product product = products.findProductByName(productName).orElseThrow(
            () -> new IllegalArgumentException(ExceptionMessage.NOT_FOUND_PRODUCT.getMessage()));

        state.purchaseProduct(product, this);
    }

    public void minusProductCount(final Product product) {
        product.minusAmount();
    }

    public void inputPrice(int price) {
        state.plusPrice(price, this);
    }

    public void plusInputPrice(int price) {
        this.hasPrice = hasPrice.plusPrice(price);
    }

    public void minusInputPrice(Product purchaseProduct) {
        Price price = products.findProductPrice(purchaseProduct)
            .orElseThrow(() -> new IllegalArgumentException(
                ExceptionMessage.NOT_FOUND_PRODUCT.getMessage()));
        this.hasPrice = hasPrice.minusPrice(price.getPrice());
    }

    public boolean checkAllSoldout(){
        return products.checkAllSoldOut();
    }

    public boolean hasPriceLessThanAllProductPrice(){
        return products.hasPriceLessThanAllProductPrice(this.hasPrice);
    }

}