package com.hyp.lightning.codec;

import com.hyp.lightning.common.RpcResponse;
import com.hyp.lightning.serialize.Hessian2Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Created by yaping_huang on 2017/6/19.
 */
public class RpcResponseEncoder extends MessageToByteEncoder<RpcResponse> {
    Hessian2Serialization serialization = new Hessian2Serialization();
    @Override
    protected  void encode(ChannelHandlerContext ctx, RpcResponse msg, ByteBuf out) throws Exception {
        Exception exception = msg.getException();
        int eLength = 0;
        byte[] bException={};
        if(exception!=null){
            bException = msg.getException().getCause().getMessage().getBytes();
            eLength = bException.length;
        }
        //固定长度为requestId+processTime  8+8=16字节
        out.writeLong(msg.getRequestId());
        out.writeLong(msg.getProcessTime());
        out.writeInt(eLength);
        if(eLength>0){
            out.writeBytes(bException);
        }
        byte[] value = serialization.serialize(msg.getValue());
        out.writeInt(value.length);
        out.writeBytes(value);
    }
}
