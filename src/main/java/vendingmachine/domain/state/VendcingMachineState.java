package vendingmachine.domain.state;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;

public interface VendcingMachineState {

    void plusPrice(int price, VendingMachine vendingMachine);

    void purchaseProduct(Product product, VendingMachine vendcingMachine);

}