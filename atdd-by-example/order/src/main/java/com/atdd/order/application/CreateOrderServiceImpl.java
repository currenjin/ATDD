package com.atdd.order.application;

import com.atdd.order.domain.PendingOrder;
import com.atdd.order.domain.PendingOrderRepository;
import org.springframework.stereotype.Service;

@Service
class CreateOrderServiceImpl implements CreateOrderService {

    private final PendingOrderRepository pendingOrderRepository;

    CreateOrderServiceImpl(PendingOrderRepository pendingOrderRepository) {
        this.pendingOrderRepository = pendingOrderRepository;
    }

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }

}
