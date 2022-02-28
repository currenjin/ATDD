package com.atdd.order.application;

import com.atdd.order.domain.PendingOrder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class createOrderServiceTest {

    private CreateOrderService createOrderService = new CreateOrderServiceImpl();

    @Test
    void createPendingOrder() {
        Long productId = 1L;
        Integer quantity = 2;
        PendingOrderRequest request = PendingOrderRequest.of(productId, quantity);

        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        assertThat(pendingOrder.getId()).isPositive();
    }

}
