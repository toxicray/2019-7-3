package com.example.socket.socket_02;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Package:com.example.socket.socket_02
 * *Author:ray
 * *version:...
 * *Created in 2019/6/30  21:42
 **/
public class UdpProvider {
	public static void main(String[] args) throws IOException {
		System.out.println("Provider started");
		//作为接收者,指定一个端口用于数据接收
		DatagramSocket ds=new DatagramSocket(20000);
		//构建接收实体
		final byte[] buf=new byte[512];
		DatagramPacket receivePack=new DatagramPacket(buf,buf.length);
		//接收
		ds.receive(receivePack);
		//打印接收到的信息与发送者的消息
		String ip=receivePack.getAddress().getHostAddress();
		int port=receivePack.getPort();
		int length = receivePack.getLength();
		String data=new String(receivePack.getData(),0,length);

		//构建一个回送数据
		String responseData="Receive data with len:"+length;
		byte[] bytes = responseData.getBytes();
		DatagramPacket responsePacket=new DatagramPacket(bytes,bytes.length,receivePack.getAddress(),receivePack.getPort());
		ds.send(responsePacket);
		System.out.println("发送结束");
		ds.close();
	}
}
