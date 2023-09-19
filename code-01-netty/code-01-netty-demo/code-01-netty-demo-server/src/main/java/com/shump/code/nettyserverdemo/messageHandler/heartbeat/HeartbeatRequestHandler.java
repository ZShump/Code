package com.shump.code.nettyserverdemo.messageHandler.heartbeat;

import com.shump.code.nettycommondemo.codec.Invocation;
import com.shump.code.nettycommondemo.dispatcher.MessageHandler;
import com.shump.code.nettyserverdemo.message.heartbeat.HeartbeatRequest;
import com.shump.code.nettyserverdemo.message.heartbeat.HeartbeatResponse;
import io.netty.channel.Channel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author zcq
 * @Classname
 * @date 2023/9/19
 * @Description
 */
@Component
public class HeartbeatRequestHandler implements MessageHandler<HeartbeatRequest> {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void execute(Channel channel, HeartbeatRequest message) {
        logger.info("[execute][收到连接({}) 的心跳请求]", channel.id());
        // 响应心跳
        HeartbeatResponse response = new HeartbeatResponse();
        channel.writeAndFlush(new Invocation(HeartbeatResponse.TYPE, response));
    }

    @Override
    public String getType() {
        return HeartbeatRequest.TYPE;
    }

}
