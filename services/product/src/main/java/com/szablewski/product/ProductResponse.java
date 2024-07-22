package com.szablewski.product;

import java.math.BigDecimal;

public record ProductResponse(
        Integer productId,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
