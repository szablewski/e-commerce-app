package com.szablewski.product;

import com.szablewski.category.Category;
import org.springframework.stereotype.Service;

@Service
class ProductMapper {

    Product toProduct(final ProductRequest request) {
        return Product.builder()
                .productId(request.productId())
                .name(request.name())
                .description(request.description())
                .availableQuantity(request.availableQuantity())
                .price(request.price())
                .category(
                        Category.builder()
                                .categoryId(request.categoryId())
                                .build())
                .build();
    }

    ProductResponse toProductResponse(final Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getAvailableQuantity(),
                product.getPrice(),
                product.getCategory().getCategoryId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    ProductPurchaseResponse toProductPurchaseResponse(final Product product,final double quantity) {
        return new ProductPurchaseResponse(
                product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
