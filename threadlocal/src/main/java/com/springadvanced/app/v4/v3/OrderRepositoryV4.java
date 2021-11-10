package com.springadvanced.app.v4.v3;

import com.springadvanced.trace.TraceStatus;
import com.springadvanced.trace.logtrace.LogTrace;
import com.springadvanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) {
        AbstractTemplate<Void> template = new AbstractTemplate<>(trace) {
            @Override
            protected Void call() {
                if (itemId.equals("ex")) {
                    throw new IllegalStateException("Exception!");
                }

                return null;
            }
        };

        template.execute("OrderRepository.save()");
    }
}
