package com.shump.code.nettycommondemo.codec;

import com.alibaba.fastjson.JSON;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.handler.codec.CorruptedFrameException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author zcq
 * @Classname
 * @date 2023/9/13
 * @Description
 */
public class InvocationDecoder extends ByteToMessageDecoder{
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) {
        // <2.1> 标记当前读取位置
        in.markReaderIndex();
        // <2.2> 判断是否能够读取 length 长度
        if (in.readableBytes() <= 4) {
            return;
        }
        // <2.3> 读取长度
        int length = in.readInt();
        if (length < 0) {
            throw new CorruptedFrameException("negative length: " + length);
        }
        // <3.1> 如果 message 不够可读，则退回到原读取位置
        if (in.readableBytes() < length) {
            in.resetReaderIndex();
            return;
        }
        // <3.2> 读取内容
        byte[] content = new byte[length];
        in.readBytes(content);
        // <3.3> 解析成 Invocation
        Invocation invocation = JSON.parseObject(content, Invocation.class);
        out.add(invocation);
        logger.info("[decode][连接({}) 解析到一条消息({})]", ctx.channel().id(), invocation.toString());
    }
}
