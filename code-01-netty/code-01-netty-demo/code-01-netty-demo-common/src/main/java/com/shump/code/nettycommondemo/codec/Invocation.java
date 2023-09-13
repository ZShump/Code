package com.shump.code.nettycommondemo.codec;

import com.alibaba.fastjson.JSON;
import com.shump.code.nettycommondemo.dispatcher.Message;

/**
 * @author zcq
 * @Classname
 * @date 2023/9/13
 * @Description 通信协议的消息体
 */
public class Invocation {
    /**
     * 类型
     */
    private String type;
    /**
     * 消息，JOSN格式
     */
    private String message;

    public Invocation(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public Invocation(String type, Message message) {
        this.type = type;
        this.message = JSON.toJSONString(message);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
