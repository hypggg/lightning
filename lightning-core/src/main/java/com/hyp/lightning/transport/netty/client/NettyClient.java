package com.hyp.lightning.transport.netty.client;

import com.hyp.lightning.codec.RpcRequestEncoder;
import com.hyp.lightning.codec.RpcResponseDecoder;
import com.hyp.lightning.common.RpcRequest;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;


/**
 * Created by huangyp on 2017/6/28.
 */
public class NettyClient {
    public static void  main(String[] args ) throws Exception{
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        Bootstrap b = null;
        try {
             b = new Bootstrap();
            b.group(workerGroup);
            b.channel(NioSocketChannel.class) .
                    handler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast("logging", new LoggingHandler(LogLevel.INFO));

                            ch.pipeline().addLast(new RpcResponseDecoder());
                            ch.pipeline().addLast(new NettyClientHandler());
                            ch.pipeline().addLast(new RpcRequestEncoder());

                        }
                    });
            Channel channel =  b.connect("127.0.0.1",8080).sync().channel();
            RpcRequest rpcRequest = new RpcRequest();
            rpcRequest.setRequestId(123123L);
            rpcRequest.setInterfaceName("com.hyp.service.A");
            rpcRequest.setMethodName("helloWork");
            rpcRequest.setParams("a,b,112");
            channel.writeAndFlush(rpcRequest);
            channel.closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
        }
    }
}
