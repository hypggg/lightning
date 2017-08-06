package com.hyp.lightning.transport.netty;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;

/**
 * Created by yaping_huang on 2017/8/5.
 */
public class NettyChannelFactory extends BasePooledObjectFactory{
    public NettyChannelFactory() {
        super();
    }

    @Override
    public PooledObject makeObject() throws Exception {
        return super.makeObject();
    }

    @Override
    public void destroyObject(PooledObject p) throws Exception {
        super.destroyObject(p);
    }

    @Override
    public boolean validateObject(PooledObject p) {
        return super.validateObject(p);
    }

    @Override
    public void activateObject(PooledObject p) throws Exception {
        super.activateObject(p);
    }

    @Override
    public void passivateObject(PooledObject p) throws Exception {
        super.passivateObject(p);
    }

    @Override
    public Object create() throws Exception {
        return null;
    }

    @Override
    public PooledObject wrap(Object o) {
        return null;
    }
}
