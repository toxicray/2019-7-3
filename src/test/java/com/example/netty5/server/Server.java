package com.example.netty5.server;

/**
 * Package:com.example.netty5.server
 * *Author:ray
 * *version:...
 * *Created in 2019/6/23  1:06
 **/

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * @Description netty5的server
 * @Param
 * @return
 **/
public class Server {
	public static void main(String[] args){
		ServerBootstrap bootStrap = new ServerBootstrap();
		//worker和boss
		EventLoopGroup boss = new NioEventLoopGroup();
		EventLoopGroup worker = new NioEventLoopGroup();

		try {
			bootStrap.group(boss,worker );
			//创建socket工厂
			bootStrap.channel(NioServerSocketChannel.class);
			//设置管道工厂
			bootStrap.childHandler(new ChannelInitializer<Channel>() {
				@Override
				protected void initChannel(Channel channel) throws Exception {
					channel.pipeline().addLast(new StringDecoder());
					channel.pipeline().addLast(new StringEncoder());
					channel.pipeline().addLast(new ServerHandler());
				}
			});
			//设置参数,TCP参数包含了很多,这只是其中的一小部分
			bootStrap.option(ChannelOption.SO_BACKLOG, 2048);//设置服务器的连接缓冲池大小
			bootStrap.childOption(ChannelOption.SO_KEEPALIVE,true );//socketChannel的设置,底层socket检查连接,可能会有超时关闭连接,清除一些死链接
			bootStrap.childOption(ChannelOption.TCP_NODELAY,true );//tcp的底层优化,关闭延迟发送的缓冲

			//绑定端口
			ChannelFuture future = bootStrap.bind(10101);
			//等待服务端关闭
			future.channel().closeFuture().sync();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			boss.shutdownGracefully();
			worker.shutdownGracefully();
		}
	}
}

