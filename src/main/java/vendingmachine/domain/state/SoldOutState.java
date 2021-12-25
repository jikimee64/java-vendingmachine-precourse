package vendingmachine.domain.state;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.ExceptionMessage;

public class SoldOutState implements VendcingMachineState {

    @Override
    public void plusPrice(int price, VendingMachine vendingMachine) {
        System.out.println(ExceptionMessage.ALL_SOLDOUT_PRODUCT.getMessage());
    }

    @Override
    public void purchaseProduct(Product product, VendingMachine vendingMachine) {
        System.out.println(ExceptionMessage.ALL_SOLDOUT_PRODUCT.getMessage());
    }

}