package com.atdd.order.application;

import com.atdd.order.domain.PendingOrder;
import com.atdd.order.domain.PendingOrderRepository;
import com.atdd.order.infra.PendingOrderRepositoryMemoryImpl;

class CreateOrderServiceImpl implements CreateOrderService {

    private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

    @Override
    public PendingOrder createPendingOrder(PendingOrderRequest request) {
        PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
        return pendingOrderRepository.save(pendingOrder);
    }

}
