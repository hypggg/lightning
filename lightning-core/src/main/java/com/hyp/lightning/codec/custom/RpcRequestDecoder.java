package com.hyp.lightning.codec.custom;

import com.hyp.lightning.common.RpcRequest;
import com.hyp.lightning.serialize.Hessian2Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;

import java.util.List;

/**
 * RpcResponse解码器，用于客户端接收到消息后处理,RpcRequest 最小13个字节
 * Created by yaping_huang on 2017/6/23.
 */
public class RpcRequestDecoder extends ByteToMessageDecoder{
    Hessian2Serialization serialization = new Hessian2Serialization();
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("decode msg ");
        if(in.readableBytes()<13){
            return;
        }
        in.markReaderIndex();
        //读固定长度部分
        long requestId = in.readLong();
        short interfaceLength = in.readShort();
        byte methodLength = in.readByte();
        short paramsLength = in.readShort();
        System.out.println("requestId:"+requestId+",interfaceLength:"+interfaceLength+",methodLength:"+methodLength+",paramsLength:"+
        paramsLength);
        //读实际内容部分
        int totalLength = interfaceLength+methodLength+paramsLength;
        if(in.readableBytes()<totalLength){
            return;
        }
        ByteBuf interfaceNameBuf = in.readBytes(interfaceLength);
        System.out.println("interfaceName:"+interfaceNameBuf.toString(CharsetUtil.UTF_8));
        ByteBuf methodNameBuf = in.readBytes(methodLength);
        ByteBuf paramsBuf = in.readBytes(paramsLength);

        RpcRequest rpcRequest = new RpcRequest(requestId,interfaceLength,methodLength,paramsLength,interfaceNameBuf.toString(CharsetUtil.UTF_8),
        methodNameBuf.toString(CharsetUtil.UTF_8),paramsBuf.toString(CharsetUtil.UTF_8));
        out.add(rpcRequest);
    }
}

