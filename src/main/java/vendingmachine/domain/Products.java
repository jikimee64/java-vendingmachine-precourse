package vendingmachine.domain;

import java.util.List;
import java.util.Optional;

public class Products {

    private List<Product> products;

    public Products(final List<Product> products) {
        this.products = products;
    }

    public Optional<Product> findProductByName(final String productName){
        return products.stream()
            .filter(product -> product.isSameProductName(product.getProductName()))
            .findFirst();
    }

    public Optional<Price> findProductPrice(final Product purchaseProduct){
        return products.stream()
            .filter(product -> product.equals(purchaseProduct))
            .map(Product::getPrice)
            .findFirst();
    }

    public boolean checkAllSoldOut(){
        return products.stream()
            .allMatch(Product::hasNonProduct);
    }

    public boolean hasPriceLessThanAllProductPrice(Price hasPrice){
        return products.stream()
            .allMatch(product -> product.hasPriceLessThanProductPrice(hasPrice));

    }

}