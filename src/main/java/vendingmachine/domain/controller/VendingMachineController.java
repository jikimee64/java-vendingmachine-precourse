package vendingmachine.domain.controller;

import java.util.Map;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;
import vendingmachine.domain.strategy.RandomGenerate;
import vendingmachine.view.InputView;
import vendingmachine.view.OutputView;

public class VendingMachineController {

    public void process(){
        int machinePrice = InputView.getMachinePrice();
        Coins coins = new Coins(new RandomGenerate());

        Map<Coin, Integer> coinIntegerMap = coins.generateCoins(machinePrice);

        OutputView.printVendingMachineCoins(coinIntegerMap);

    }

}