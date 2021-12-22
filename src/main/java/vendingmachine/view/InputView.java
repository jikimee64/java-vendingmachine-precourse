package vendingmachine.view;

import camp.nextstep.edu.missionutils.Console;
import vendingmachine.exception.ExceptionMessage;
import vendingmachine.utils.NumberUtils;

public class InputView {

    private static final String INPUT_CONTAINS_COINS = "자판기가 보유하고 있는 금액을 입력해 주세요.";
    private static final String INPUT_PRODUCT_INVENTORY = "상품명과 가격, 수량을 입력해 주세요.";
    private static final String INPUT_PRICE = "투입 금액을 입력해 주세요.";
    private static final String INPUT_PURCHASE_PRODUCT = "구매할 상품명을 입력해 주세요.";

    public static int getMachinePrice(){
        System.out.println(INPUT_CONTAINS_COINS);
        return strToInt(Console.readLine());
    }

    private static int strToInt(String str){
        if(!NumberUtils.isDigit(str)){
            ExceptionMessage.nonNumberFormat();
        }
        return Integer.parseInt(str);
    }

}