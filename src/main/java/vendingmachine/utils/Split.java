package vendingmachine.utils;

import java.util.List;
import java.util.stream.Collectors;
import vendingmachine.domain.Product;
import vendingmachine.exception.ExceptionMessage;

public class Split {

    public static final String SEMI_COLON = ";";
    public static final String COMMA = ",";

    public static List<Product> getProducts(String inputProduct) {
        return divisionInventory(inputProduct).stream()
            .map(product -> {
                List<String> inventory = Split.getSplitComma(product);
                return new Product(
                    inventory.get(0),
                    Validation.validPriceGreaterThanAndUnit(parseAndValidPriceDigit(inventory.get(1))),
                    parseAndValidAmountDigit(inventory.get(2))
                );
            }).collect(Collectors.toList());
    }

    private static int parseAndValidPriceDigit(String str){
        if(!NumberUtils.isDigit(str)){
            throw new IllegalArgumentException(ExceptionMessage.PRICE_NUMBER_FORMAT.getMessage());
        }
        return Integer.parseInt(str);
    }

    private static int parseAndValidAmountDigit(String str){
        if(!NumberUtils.isDigit(str)){
            throw new IllegalArgumentException(ExceptionMessage.AMOUNT_NUMBER_FORMAT.getMessage());
        }
        return Integer.parseInt(str);
    }


    private static List<String> divisionInventory(String inputProduct){
        return StringUtils.splitStr(inputProduct, SEMI_COLON).stream()
            .map(value -> StringUtils.substringStr(value, 1, value.length()-1))
            .collect(Collectors.toList());
    }

    public static List<String> getSplitComma(String inputProduct){
        return StringUtils.splitStr(inputProduct, COMMA);
    }

}