package com.springadvanced.trace.callback;

import com.springadvanced.trace.TraceStatus;
import com.springadvanced.trace.logtrace.LogTrace;

public class TraceTemplate {

    private final LogTrace trace;

    public TraceTemplate(LogTrace trace) {
        this.trace = trace;
    }

    public <T> T execute(String message, TraceCallback<T> callback) {
        TraceStatus status = null;
        try {
            status = trace.begin(message);
            T result = callback.call();
            trace.end(status);

            return result;
        } catch (Exception exception) {
            trace.exception(status, exception);
            throw exception;
        }
    }
}
