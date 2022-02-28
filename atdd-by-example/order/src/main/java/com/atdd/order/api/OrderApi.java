package com.atdd.order.api;

import com.atdd.order.application.CreateOrderService;
import com.atdd.order.application.PendingOrderRequest;
import com.atdd.order.application.PendingOrderResponse;
import com.atdd.order.domain.PendingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApi {

    private final CreateOrderService createOrderService;

    public OrderApi(CreateOrderService createOrderService) {
        this.createOrderService = createOrderService;
    }

    @PostMapping("/orders/pendingOrder")
    public ResponseEntity<PendingOrderResponse> createPendingOrder(@RequestBody PendingOrderRequest request) {
        PendingOrder pendingOrder = createOrderService.createPendingOrder(request);
        PendingOrderResponse response = new PendingOrderResponse(pendingOrder);
        return ResponseEntity.ok(response);
    }
}
