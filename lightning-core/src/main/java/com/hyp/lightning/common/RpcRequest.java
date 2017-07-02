package com.hyp.lightning.common;

import java.io.Serializable;

/**
 * Created by yaping_huang on 2017/6/19.
 * 请求体》=8+2+1+2=13个字节
 */
public class RpcRequest implements Serializable {
    private long requestId;  //请求方ID 8个字节,
    private short interfaceLength;  //接口名称长度
    private byte methodLength;  //方法名称长度
    private short paramsLength; //方法参数长度
    private String interfaceName;  //接口名称（包含包路径）
    private String methodName;   //方法名
    private String params;


    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public long getRequestId() {
        return requestId;
    }

    public void setRequestId(long requestId) {
        this.requestId = requestId;
    }

    public short getInterfaceLength() {
        return interfaceLength;
    }

    public void setInterfaceLength(short interfaceLength) {
        this.interfaceLength = interfaceLength;
    }

    public byte getMethodLength() {
        return methodLength;
    }

    public void setMethodLength(byte methodLength) {
        this.methodLength = methodLength;
    }

    public short getParamsLength() {
        return paramsLength;
    }

    public void setParamsLength(short paramsLength) {
        this.paramsLength = paramsLength;
    }

    public RpcRequest() {
    }

    public RpcRequest(long requestId, short interfaceLength, byte methodLength, short paramsLength, String interfaceName, String methodName, String params) {
        this.requestId = requestId;
        this.interfaceLength = interfaceLength;
        this.methodLength = methodLength;
        this.paramsLength = paramsLength;
        this.interfaceName = interfaceName;
        this.methodName = methodName;
        this.params = params;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "requestId=" + requestId +
                ", interfaceLength=" + interfaceLength +
                ", methodLength=" + methodLength +
                ", paramsLength=" + paramsLength +
                ", interfaceName='" + interfaceName + '\'' +
                ", methodName='" + methodName + '\'' +
                ", params='" + params + '\'' +
                '}';
    }
}
