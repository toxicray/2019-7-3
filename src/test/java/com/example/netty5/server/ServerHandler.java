package com.example.netty5.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Package:com.example.netty5.server
 * *Author:ray
 * *version:...
 * *Created in 2019/6/23  1:23
 **/
public class ServerHandler extends SimpleChannelInboundHandler<String>{

	@Override
	protected void channelRead0(ChannelHandlerContext channelHandlerContext, String str) throws Exception {
		System.out.println(str);
		channelHandlerContext.writeAndFlush("hi");
	}

	@Override
	public void channelActive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel active");
		super.channelActive(ctx);
	}

	@Override
	public void channelInactive(ChannelHandlerContext ctx) throws Exception {
		System.out.println("channel InActive");
		super.channelInactive(ctx);
	}

}
