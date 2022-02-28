package com.atdd.order.api;

import com.atdd.order.application.PendingOrderRequest;
import com.atdd.order.application.PendingOrderResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderApi {

    @PostMapping("/orders/pendingOrder")
    public ResponseEntity<PendingOrderResponse> createPendingOrder(@RequestBody PendingOrderRequest request) {
        PendingOrderResponse response = new PendingOrderResponse(request.getProductId(), request.getQuantity());
        return ResponseEntity.ok(response);
    }
}
