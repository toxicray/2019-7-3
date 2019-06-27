package com.example.netty5.client;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.concurrent.EventExecutorGroup;

/**
 * Package:com.example.netty5.client
 * *Author:ray
 * *version:...
 * *Created in 2019/6/23  22:20
 **/
public class ClientHandler extends SimpleChannelInboundHandler<String> {
	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, String string) throws Exception {
		System.out.println(string);
	}
}
