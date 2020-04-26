package disruptor.quickstart;

import com.lmax.disruptor.EventFactory;

/**
 * Package:disruptor.quickstart
 * *Author:ray
 * *version:...
 * *Created in 2020/4/24  0:16
 **/
public class OrderEventFactory implements EventFactory<OrderEvent> {
	@Override
	public OrderEvent newInstance() {
		return new OrderEvent();  //返回空的数据对象
	}
}
