package vendingmachine.exception;

public class ExceptionMessage {

    private static String PREIFX = "[ERROR] ";
    private static String NUMBER_FORMAT = "금액은 숫자여야 합니다.";
    private static String NOT_ZERO = "0보다 큰 금액을 입력해주세요.";

    public static String nonNumberFormat() {
        return PREIFX + NUMBER_FORMAT;
    }

    public static String nonZeroCoin() {
        return PREIFX + NOT_ZERO;
    }

}