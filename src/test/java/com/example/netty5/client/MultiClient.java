package com.example.netty5.client;

/**
 * Package:com.example.netty5.client
 * *Author:ray
 * *version:...
 * *Created in 2019/6/23  23:09
 **/

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Description 多连接客户端
 * @Param
 * @return
 **/
public class MultiClient {

	//引用计数器
	private final AtomicInteger index = new AtomicInteger();


	/**
	 * @Description 服务类
	 * @Param
	 * @return
	 **/
	private Bootstrap bootstrap = new Bootstrap();

	/**
	 * @Description 会话
	 * @Param
	 * @return
	 **/
	private List<Channel> channels = new ArrayList<>();


	public void init(int count) {
		EventLoopGroup worker = new NioEventLoopGroup();

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

		for (int i = 0; i < count; i++) {
			ChannelFuture connect = bootstrap.connect("127.0.0.1", 10101);
			channels.add(connect.channel());
		}
	}

	public Channel nextChannel() {
		return getFirstActiveChannel(0);
	}


	private Channel getFirstActiveChannel(int count) {
		Channel channel = channels.get(Math.abs(index.incrementAndGet() % channels.size()));
		if (!channel.isActive()){
		    //重连
			if (count>=channels.size()){
			    throw new RuntimeException("No channel avilabel!");
			}
			return getFirstActiveChannel(count+1);
		}
		return channel;
	}

	private void reconnect(Channel channel){
		synchronized (channel){
			if (channels.indexOf(channel)==-1){
			    return;
			}
			Channel newchannel=bootstrap.connect("127.0.0.1", 10101).channel();
			channels.set(channels.indexOf(channel),newchannel );
		}
	}



	public static void main(String[] args) {


	}
}
