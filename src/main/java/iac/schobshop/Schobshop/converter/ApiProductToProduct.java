package iac.schobshop.Schobshop.converter;

import iac.schobshop.Schobshop.command.ApiProduct;
import iac.schobshop.Schobshop.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ApiProductToProduct implements Converter<ApiProduct, Product> {
    @Override
    public Product convert(ApiProduct apiProduct) {
        Product product = new Product();
        product.setId(apiProduct.getId());
        product.setName(apiProduct.getName());
        product.setPrice(apiProduct.getPrice());
        product.setDescription(apiProduct.getDescription());
        product.setSellable(apiProduct.isSellable());
        return product;
    }
}
