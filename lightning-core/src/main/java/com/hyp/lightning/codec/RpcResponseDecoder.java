package com.hyp.lightning.codec;

import com.hyp.lightning.common.RpcResponse;
import com.hyp.lightning.serialize.Hessian2Serialization;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * RpcResponse解码器，用于客户端接收到消息后处理
 * Created by yaping_huang on 2017/6/23.
 */
public class RpcResponseDecoder extends ByteToMessageDecoder{
    Logger logger = LoggerFactory.getLogger(RpcResponse.class);
    Hessian2Serialization serialization = new Hessian2Serialization();
    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {

            System.out.println("decode RpcResonse ");
            if(in.readableBytes()<16){
                return;
            }
            long requestId = in.readLong();
            long processTime = in.readLong();
            int exceptionSize = in.readInt();

            String exception = in.readBytes(exceptionSize).toString(CharsetUtil.UTF_8);
            int valueSize = in.readInt();
            String value = in.readBytes(valueSize).toString(CharsetUtil.UTF_8);
            RpcResponse rpcResponse = new RpcResponse();
            rpcResponse.setValue(value);
            rpcResponse.setProcessTime(processTime);
            rpcResponse.setRequestId(requestId);
            rpcResponse.setException(new Exception(exception));
            out.add(rpcResponse);

    }
}

