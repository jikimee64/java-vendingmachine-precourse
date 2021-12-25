package vendingmachine.domain.state;

import vendingmachine.domain.Product;
import vendingmachine.domain.VendingMachine;
import vendingmachine.exception.ExceptionMessage;

public class SelectedState implements VendcingMachineState {

    @Override
    public void plusPrice(int price, VendingMachine vendingMachine) {
        vendingMachine.plusInputPrice(price);
    }


    // 잔돈을 돌려줄 때 현재 보유한 최소 개수의 동전으로 잔돈을 돌려준다.
    // 잔돈을 반환할 수 없는 경우 잔돈으로 반환할 수 있는 금액만 반환한다.
    //    반환되지 않은 금액은 자판기에 남는다.
    @Override
    public void purchaseProduct(Product product, VendingMachine vendingMachine) {

        //TODO: 모든 상품이 소진된 경우 잔돈 반환
        if(vendingMachine.checkAllSoldout()){
            System.out.println(ExceptionMessage.ALL_SOLDOUT_PRODUCT.getMessage());
            vendingMachine.changeState(new SoldOutState());
            return;
        }

        //물건 품절 검사
        if (product.hasNonProduct()) {
            System.out.println(ExceptionMessage.SOLDOUT_PRODUCT.getMessage());
            return;
        }

        //TODO: 남은 금액이 상품의 최저 가격보다 적을때 잔돈 반환
        if(vendingMachine.hasPriceLessThanAllProductPrice()){

            return;
        }

        //물건수량 하나감소
        vendingMachine.minusProductCount(product);

        //자판기 투입금액 감소
        vendingMachine.minusInputPrice(product);

    }

}