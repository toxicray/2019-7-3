package com.example.aqs.ForkJoin;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
 * Package:com.example.aqs.ForkJoin
 * *Author:ray
 * *version:...
 * *Created in 2019/5/27  22:21
 **/
@Slf4j
public class ForkJoinTaskExample extends RecursiveTask<Integer> {

	public static final int threshold=2;
	private int start;
	private int end;

	public ForkJoinTaskExample(int start,int end){
		this.start=start;
		this.end=end;
	}

	@Override
	protected Integer compute() {
		int sum=0;
		boolean canCompute=(end-start)<=threshold;
		if (canCompute){
			for (int i=start; i <= end; i++) {
				sum+=i;
			}
		}else {
		    int middle=(start+end)/2;
		    ForkJoinTaskExample leftTask=new ForkJoinTaskExample(start,middle);
			ForkJoinTaskExample rightTask=new ForkJoinTaskExample(middle+1,end);
			//执行子任务
			leftTask.fork();
			rightTask.fork();
			//等待任务结束合并其结果
			int leftResult=leftTask.join();
			int rightResult=rightTask.join();
			//合并子任务
			sum=leftResult+rightResult;
		}
		return sum;
	}
	public static void main(String[] args) {
		ForkJoinPool forkJoinPool=new ForkJoinPool();
		//生成一个计算任务,计算1+2=3
		ForkJoinTaskExample task=new ForkJoinTaskExample(1,100);
		//执行一个任务
		Future<Integer> result=forkJoinPool.submit(task);
		try {
			log.info("result:{}",result.get() );
		} catch(Exception e) {
		    log.error("exception",e );
		}
	}
}
