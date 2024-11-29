package com.szablewski.handler;

import java.util.Map;

record ErrorResponse(
        Map<String, String> errors
) {
}
