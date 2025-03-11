package com.test.naren.base_app.exception;

public class ProductNotFoundException extends RuntimeException {
    private final String endpoint;
    private final Integer productId;

    public ProductNotFoundException(String message, String endpoint, Integer productId) {
        super(message);
        this.endpoint = endpoint;
        this.productId = productId;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public Integer getProductId() {
        return productId;
    }
}