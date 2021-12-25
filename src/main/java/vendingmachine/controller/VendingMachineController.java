package vendingmachine.controller;

import java.util.List;
import vendingmachine.domain.Coins;
import vendingmachine.domain.Product;
import vendingmachine.domain.Products;
import vendingmachine.domain.VendingMachine;
import vendingmachine.domain.strategy.RandomGenerate;
import vendingmachine.utils.Split;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void process() {
        Coins coins = generateCoinsOfVendingMachine();
        OutputView.printVendingMachineCoins(coins);

        Products products = new Products(generateProductsOfVendingMachine());
        int inputPrice = InputView.getInputPrice();

        VendingMachine vendingMachine = new VendingMachine(products, coins);
        vendingMachine.inputPrice(inputPrice);

    }

    private Coins generateCoinsOfVendingMachine() {
        int containsPrice = InputView.getMachinePrice();
        Coins coins = new Coins(new RandomGenerate());
        coins.generateCoins(containsPrice);
        return coins;
    }

    private List<Product> generateProductsOfVendingMachine() {
        String inputProducts = InputView.getProductInventory();
        return Split.getProducts(inputProducts);
    }

}