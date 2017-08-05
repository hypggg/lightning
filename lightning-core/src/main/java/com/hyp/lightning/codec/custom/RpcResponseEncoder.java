package com.hyp.lightning.codec.custom;

import com.hyp.lightning.serialize.Hessian2Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by yaping_huang on 2017/6/19.
 */
public class RpcResponseEncoder extends MessageToByteEncoder<RpcResponseEncoder> {
    Hessian2Serialization serialization = new Hessian2Serialization();
    @Override
    protected  void encode(ChannelHandlerContext ctx, RpcResponseEncoder msg, ByteBuf out) throws Exception {
            out.writeBytes(serialization.serialize(msg));
    }
}
