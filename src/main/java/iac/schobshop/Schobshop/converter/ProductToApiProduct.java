package iac.schobshop.Schobshop.converter;

import iac.schobshop.Schobshop.command.ApiProduct;
import iac.schobshop.Schobshop.model.Product;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class ProductToApiProduct implements Converter<Product, ApiProduct> {
    @Override
    public ApiProduct convert(Product product) {
        ApiProduct apiProduct = new ApiProduct();
        apiProduct.setId(product.getId());
        apiProduct.setName(product.getName());
        apiProduct.setPrice(product.getPrice());
        apiProduct.setSellable(product.isSellable());
        apiProduct.setDescription(product.getDescription());
        apiProduct.setProductImage("/product/"+ product.getId()+"/image");
        return apiProduct;
    }
}
