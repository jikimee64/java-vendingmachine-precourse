package vendingmachine.view;

import java.util.Map.Entry;
import vendingmachine.domain.Coin;
import vendingmachine.domain.Coins;

public class OutputView {

    private static final String CONTAIN_COINS = "자판기가 보유한 동전";
    private static final String DASH = " - ";
    private static final String COUNT = "개";
    private static final String ONE = "원";

    public static void printVendingMachineCoins(Coins coins){
        System.out.println(CONTAIN_COINS);
        for (Entry<Coin, Integer> entry : coins.getCoinMap().entrySet()) {
            System.out.println(entry.getKey().getPrice() + ONE + DASH + entry.getValue() + COUNT);
        }
    }

}