package com.hyp.lightning.serialize;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.Hessian2Output;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * Created by yaping_huang on 2017/6/20.
 */
public class Hessian2Serialization {

    public byte[] serialize(Object data) throws IOException{
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output out = new Hessian2Output(bos);
        out.writeObject(data);
        out.flush();;
        return bos.toByteArray();
    }

    public <T> T deserialize(byte[] data,Class<T> clz) throws IOException{
        Hessian2Input input = new Hessian2Input(new ByteArrayInputStream(data));
        return (T)input.readObject(clz);
    }

}
