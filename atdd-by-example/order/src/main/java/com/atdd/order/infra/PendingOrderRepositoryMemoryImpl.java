package com.atdd.order.infra;

import com.atdd.order.domain.PendingOrder;
import com.atdd.order.domain.PendingOrderRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
public class PendingOrderRepositoryMemoryImpl implements PendingOrderRepository {

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
