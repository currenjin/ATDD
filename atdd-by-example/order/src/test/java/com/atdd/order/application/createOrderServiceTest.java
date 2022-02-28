package com.atdd.order.application;

import com.atdd.order.domain.PendingOrder;
import com.atdd.order.domain.PendingOrderRepository;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicLong;

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

    private class CreateOrderServiceImpl implements CreateOrderService {

        private PendingOrderRepository pendingOrderRepository = new PendingOrderRepositoryMemoryImpl();

        @Override
        public PendingOrder createPendingOrder(PendingOrderRequest request) {
            PendingOrder pendingOrder = new PendingOrder(request.getProductId(), request.getQuantity());
            return pendingOrderRepository.save(pendingOrder);
        }

    }
    private static class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

        AtomicLong atomicId = new AtomicLong(1);

        @Override
        public PendingOrder save(PendingOrder pendingOrder) {
            pendingOrder.assignId(nextId());
            return pendingOrder;
        }

        private long nextId() {
            return atomicId.getAndIncrement();
        }
    }
}
