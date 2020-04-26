package disruptor.quickstart;


import com.lmax.disruptor.EventHandler;

//消息的消费者
public class OrderEventHandler implements EventHandler<OrderEvent> {

	/**
	 * 事件的驱动模式,监听消息
	 * @param event  消息对象
	 * @param sequence
	 * @param endOfBatch
	 * @throws Exception
	 */
	@Override
	public void onEvent(OrderEvent event, long sequence, boolean endOfBatch) throws Exception {
		System.out.println("消费者消费消息"+ event.getValue());
	}
}
