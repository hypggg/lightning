package com.hyp.lightning.transport;

import com.hyp.lightning.rpc.Request;
import com.hyp.lightning.rpc.Response;
import com.hyp.lightning.rpc.URL;

import java.net.InetSocketAddress;

/**
 * Created by yaping_huang on 2017/8/5.
 */
public interface Channel {
    /**
     * get local socket address.
     *
     * @return local address.
     */
    InetSocketAddress getLocalAddress();

    /**
     * get remote socket address
     *
     * @return
     */
    InetSocketAddress getRemoteAddress();

    /**
     * send request.
     *
     * @param request
     * @return response future
     * @throws TransportException
     */
    Response request(Request request) throws TransportException;

    /**
     * open the channel
     *
     * @return
     */
    boolean open();

    /**
     * close the channel.
     */
    void close();

    /**
     * close the channel gracefully.
     */
    void close(int timeout);

    /**
     * is closed.
     *
     * @return closed
     */
    boolean isClosed();

    /**
     * the node available status
     *
     * @return
     */
    boolean isAvailable();

    /**
     *
     * @return
     */
    URL getUrl();

}
