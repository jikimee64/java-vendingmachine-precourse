package vendingmachine.exception;

public enum ExceptionMessage {

    NOT_ZERO("0보다 큰 금액을 입력해주세요."),
    GREATER_HUNDRED("100원보다 큰 금액을 입력해주세요."),
    TEN_UNIT("10원단위로 입력해주세요."),
    PRICE_NUMBER_FORMAT("금액은 숫자이여야 합니다."),
    AMOUNT_NUMBER_FORMAT("수량은 숫자이어야 합니다."),
    NOT_INPUT_PRICE("금액을 투입해주세요."),
    NOT_FOUND_PRODUCT("상품이 존재하지 않습니다."),
    SOLDOUT_PRODUCT("상품이 품절되었습니다."),
    ALL_SOLDOUT_PRODUCT("모든 상품이 품절되었습니다.");

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
