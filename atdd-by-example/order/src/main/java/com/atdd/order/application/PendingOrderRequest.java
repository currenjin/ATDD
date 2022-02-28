package com.atdd.order.application;

import lombok.Getter;

@Getter
public class PendingOrderRequest {
    private long productId;
    private int quantity;

    public PendingOrderRequest(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public static PendingOrderRequest of(Long productId, Integer quantity) {
        return new PendingOrderRequest(productId, quantity);
    }
}
