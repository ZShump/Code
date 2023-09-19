package com.shump.code.nettyclientdemo.config;

import com.shump.code.nettycommondemo.dispatcher.MessageDispatcher;
import com.shump.code.nettycommondemo.dispatcher.MessageHandlerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zcq
 * @Classname
 * @date 2023/9/15
 * @Description
 */
@Configuration
public class NettyClientConfig {

    @Bean
    public MessageDispatcher messageDispatcher() {
        return new MessageDispatcher();
    }

    @Bean
    public MessageHandlerContainer messageHandlerContainer() {
        return new MessageHandlerContainer();
    }

}