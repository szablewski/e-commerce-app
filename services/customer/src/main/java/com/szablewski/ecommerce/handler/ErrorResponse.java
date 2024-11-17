package com.szablewski.ecommerce.handler;

import java.util.Map;

record ErrorResponse(
        Map<String, String> errors
) {
}
