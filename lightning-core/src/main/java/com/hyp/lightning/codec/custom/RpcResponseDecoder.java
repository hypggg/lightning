package com.hyp.lightning.codec.custom;

import com.hyp.lightning.common.RpcResponse;
import com.hyp.lightning.serialize.Hessian2Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * RpcResponse解码器，用于客户端接收到消息后处理
 * Created by yaping_huang on 2017/6/23.
 */
public class RpcResponseDecoder extends ByteToMessageDecoder{
    Hessian2Serialization serialization = new Hessian2Serialization();
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        byte[] bytes = new byte[1024*1024*10];//读取最多10M字节
        in.readBytes(bytes);
        RpcResponse rpcResponse = serialization.deserialize(bytes,RpcResponse.class);
        out.add(rpcResponse);
    }
}

