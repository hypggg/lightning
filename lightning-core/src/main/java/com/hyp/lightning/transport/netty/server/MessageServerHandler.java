package com.hyp.lightning.transport.netty.server;

import com.hyp.lightning.common.RpcRequest;
import com.hyp.lightning.common.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by yaping_huang on 2017/6/19.
 */
public class MessageServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        RpcRequest rpcRequest = (RpcRequest) msg;
        System.out.println("receive rpcRequest:"+rpcRequest);
        RpcResponse rpcResponse = new RpcResponse();
        ctx.write(rpcResponse);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channleActive");
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channleInactive");
        super.channelInactive(ctx);
    }
}
