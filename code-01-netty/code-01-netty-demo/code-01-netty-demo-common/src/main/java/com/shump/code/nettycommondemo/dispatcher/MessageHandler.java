package com.shump.code.nettycommondemo.dispatcher;

import io.netty.channel.Channel;

/**
 * @author zcq
 * @Classname
 * @date 2023/9/13
 * @Description
 */
public interface MessageHandler<T extends Message>{
    /**
     * 执行处理消息
     * @param channel
     * @param message
     */
    void execute(Channel channel , T message);
    /**
     * 消息类型 即每个 Message 实现类上的 TYPE 静态字段
     * @return
     */
    String getType();
}
