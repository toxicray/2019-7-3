package com.example.netty5.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Package:com.example.netty5.client
 * *Author:ray
 * *version:...
 * *Created in 2019/6/23  23:32
 **/
public class Start {
	public static void main(String[] args) {

		MultiClient client = new MultiClient();
		client.init(5);
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		while (true){
			System.out.print("请输入:");
			try {
				String msg = bufferedReader.readLine();
				client.nextChannel().writeAndFlush(msg);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
