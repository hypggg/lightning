package com.hyp.lightning.common;

import java.io.Serializable;

/**
 * Created by yaping_huang on 2017/6/19.
 */
public class RpcResponse implements Serializable {
    private long requestId;
    private long processTime;
    private Object value;
    private Exception exception;


    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Exception getException() {
        return exception;
    }

    public void setException(Exception exception) {
        this.exception = exception;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public long getProcessTime() {
        return processTime;
    }

    public void setProcessTime(long processTime) {
        this.processTime = processTime;
    }
}
