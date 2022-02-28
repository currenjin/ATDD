package com.atdd.order.application;

import com.atdd.order.domain.PendingOrder;

public interface CreateOrderService {
    PendingOrder createPendingOrder(PendingOrderRequest request);
}
