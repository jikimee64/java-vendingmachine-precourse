package vendingmachine.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtils {

    public static List<String> splitStr(String str, String splitStandard){
        return Arrays.asList(str.split(splitStandard));
    }

    public static String substringStr(String str, int start, int end){
        return str.substring(start, end);
    }

}