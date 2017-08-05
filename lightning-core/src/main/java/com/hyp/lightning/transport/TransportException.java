package com.hyp.lightning.transport;

import java.net.InetSocketAddress;

/**
 * Created by yaping_huang on 2017/8/5.
 */
public class TransportException extends Exception {
    private static final long serialVersionUID = 7057762354907226994L;

    private InetSocketAddress localAddress;
    private InetSocketAddress remoteAddress;

    public TransportException(InetSocketAddress localAddress, InetSocketAddress remoteAddress, String message) {
        super(message);
        this.localAddress = localAddress;
        this.remoteAddress = remoteAddress;
    }

    public TransportException(InetSocketAddress localAddress, InetSocketAddress remoteAddress, String message, Throwable cause) {
        super(message, cause);
        this.localAddress = localAddress;
        this.remoteAddress = remoteAddress;
    }

    public InetSocketAddress getLocalAddress() {
        return localAddress;
    }

    public InetSocketAddress getRemoteAddress() {
        return remoteAddress;
    }
}
