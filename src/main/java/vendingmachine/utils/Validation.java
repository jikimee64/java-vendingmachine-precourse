package vendingmachine.utils;

import vendingmachine.exception.ExceptionMessage;

public class Validation {

    public static int validPriceGreaterThanAndUnit(int price){
        if(price < 100){
            throw new IllegalArgumentException(ExceptionMessage.GREATER_HUNDRED.getMessage());
        }

        if(price % 10 != 0){
            throw new IllegalArgumentException(ExceptionMessage.TEN_UNIT.getMessage());
        }
        return price;
    }

}
