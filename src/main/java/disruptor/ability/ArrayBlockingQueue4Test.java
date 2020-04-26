package disruptor.ability;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * Package:disruptor.ability
 * *Author:ray
 * *version:...
 * *Created in 2020/4/23  23:35
 **/
public class ArrayBlockingQueue4Test {
	public static void main(String[] args) {
		final ArrayBlockingQueue<Data> queue = new ArrayBlockingQueue<>(100_000_000);
		final long startTime = System.currentTimeMillis();
		//开启一个线程去添加消息
		new Thread(() -> {
			long i = 0;
			while (i < Constants.EVENT_NUM_OM) {
				Data data = new Data(i, "c" + i);
				try {
					queue.put(data);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				i++;
			}
		}).start();

		//消费消息
		new Thread(() -> {
			int k = 0;
			while (k < Constants.EVENT_NUM_OM){
				try {
					queue.take();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				k++;
			}
			long endTime = System.currentTimeMillis();
			System.out.println(endTime-startTime);
		}).start();
	}

}
