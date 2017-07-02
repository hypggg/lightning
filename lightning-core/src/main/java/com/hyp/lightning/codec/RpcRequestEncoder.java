package com.hyp.lightning.codec;

import com.hyp.lightning.common.RpcRequest;
import com.hyp.lightning.serialize.Hessian2Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by yaping_huang on 2017/6/19.
 */
public class RpcRequestEncoder extends MessageToByteEncoder<RpcRequest> {
    Hessian2Serialization serialization = new Hessian2Serialization();
    @Override
    protected  void encode(ChannelHandlerContext ctx, RpcRequest msg, ByteBuf out) throws Exception {
        byte[] interfaceName = msg.getInterfaceName().getBytes();
        byte[] methodName = msg.getMethodName().getBytes();
        byte[] params = msg.getParams().getBytes();
        out.writeLong(msg.getRequestId());
        out.writeShort(interfaceName.length);
        out.writeByte(methodName.length);
        out.writeShort(params.length);
        out.writeBytes(interfaceName);
        out.writeBytes(methodName);
        out.writeBytes(params);

    }
}
