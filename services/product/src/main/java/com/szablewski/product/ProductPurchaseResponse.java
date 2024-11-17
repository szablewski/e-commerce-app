package com.szablewski.product;

import java.math.BigDecimal;

record ProductPurchaseResponse(
        Integer productId,
        String name,
        String description,
        BigDecimal price,
        double quantity
) {
}
