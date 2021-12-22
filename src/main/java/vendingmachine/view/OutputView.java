package vendingmachine.view;

import java.util.Map;
import java.util.Map.Entry;
import vendingmachine.domain.Coin;

public class OutputView {

    private static final String CONTAIN_COINS = "자판기가 보유한 동전";
    private static final String DASH = " - ";
    private static final String COUNT = "개";
    private static final String ONE = "원";

    public static void printVendingMachineCoins(Map<Coin, Integer> coinMaps){
        System.out.println(CONTAIN_COINS);
        for (Entry<Coin, Integer> entry : coinMaps.entrySet()) {
            System.out.println(entry.getKey().getPrice() + ONE + DASH + entry.getValue() + COUNT);
        }
    }

}
