package com.example.aqs.pool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Package:com.example.aqs.pool
 * *Author:ray
 * *version:...
 * *Created in 2019/11/6  23:53
 **/
public class RejectHandler implements RejectedExecutionHandler {
	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		System.out.println("任务满了哦");
	}
}
