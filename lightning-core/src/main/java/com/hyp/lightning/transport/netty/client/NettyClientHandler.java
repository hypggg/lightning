package com.hyp.lightning.transport.netty.client;

import com.hyp.lightning.common.RpcResponse;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by huangyp on 2017/6/28.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter{


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        if(msg instanceof  RpcResponse){
            RpcResponse rpcResponse = (RpcResponse)msg;
            System.out.println(rpcResponse.getValue());
        }else{
            System.out.println("NettyClientHandler not support msg");
        }
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("client channelActive ");

    }
}
