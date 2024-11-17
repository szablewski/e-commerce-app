package com.szablewski.product;

import java.math.BigDecimal;

record ProductResponse(
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
