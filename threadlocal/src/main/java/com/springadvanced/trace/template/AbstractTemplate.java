package com.springadvanced.trace.template;

import com.springadvanced.trace.TraceStatus;
import com.springadvanced.trace.logtrace.LogTrace;

public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public AbstractTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public T execute(String message) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = call();
            trace.end(status);

            return result;
        } catch (Exception exception) {
            trace.exception(status, exception);
            throw exception;
        }
    }

    protected abstract T call();
}
