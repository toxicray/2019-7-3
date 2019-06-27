package com.example.netty5.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Package:com.example.netty5.client
 * *Author:ray
 * *version:...
 * *Created in 2019/6/23  22:14
 **/
public class Client {
	public static void main(String[] args) {
		Bootstrap bootstrap = new Bootstrap();


		EventLoopGroup worker = new NioEventLoopGroup();
		try {
			bootstrap.group(worker);

			bootstrap.channel(NioSocketChannel.class);


			bootstrap.handler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					channel.pipeline().addLast(new StringDecoder());
					channel.pipeline().addLast(new StringEncoder());
					channel.pipeline().addLast(new ClientHandler());
				}
			});
			ChannelFuture connect = bootstrap.connect("127.0.0.1", 10101);
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			while (true) {
				System.out.println("请输入:");
				String readLine = bufferedReader.readLine();
				connect.channel().writeAndFlush(readLine);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			worker.shutdownGracefully();
		}

	}
}
