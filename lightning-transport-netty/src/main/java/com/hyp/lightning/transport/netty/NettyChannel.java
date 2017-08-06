package com.hyp.lightning.transport.netty;

import com.hyp.lightning.rpc.Request;
import com.hyp.lightning.rpc.Response;
import com.hyp.lightning.rpc.URL;
import com.hyp.lightning.transport.Channel;
import com.hyp.lightning.transport.TransportException;

import java.net.InetSocketAddress;

/**
 * Created by yaping_huang on 2017/8/5.
 */
public class NettyChannel implements Channel {

    private NettyClient nettyClient;

    public InetSocketAddress getLocalAddress() {
        return null;
    }

    public InetSocketAddress getRemoteAddress() {
        return null;
    }

    public Response request(Request request) throws TransportException {
        return null;
    }

    public boolean open() {
        return false;
    }

    public void close() {

    }

    public void close(int timeout) {

    }

    public boolean isClosed() {
        return false;
    }

    public boolean isAvailable() {
        return false;
    }

    public URL getUrl() {
        return null;
    }
}
