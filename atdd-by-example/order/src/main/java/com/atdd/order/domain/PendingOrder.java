package com.atdd.order.domain;

import lombok.Getter;

@Getter
public class PendingOrder {
    private long id;
    private long productId;
    private int quantity;

    public PendingOrder(long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void assignId(long nextId) {
        this.id = nextId;
    }
}
