package vendingmachine;

import vendingmachine.controller.VendingMachineController;

public class Application {
    public static void main(String[] args) {

        VendingMachineController vm = new VendingMachineController();
        vm.process();

    }
}