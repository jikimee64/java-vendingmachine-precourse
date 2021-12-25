package vendingmachine.domain.state;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.ExceptionMessage;

public class NoCoinState implements VendcingMachineState {

    @Override
    public void plusPrice(int price, VendingMachine vendingMachine) {
        vendingMachine.plusInputPrice(price);
        vendingMachine.changeState(new SelectedState());
    }

    @Override
    public void purchaseProduct(Product product, VendingMachine vendingMachine) {
        throw new IllegalArgumentException(ExceptionMessage.NOT_INPUT_PRICE.getMessage());
    }

}