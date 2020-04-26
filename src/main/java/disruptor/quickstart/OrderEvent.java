package disruptor.quickstart;

//相当于消息的实例对象
public class OrderEvent {

	private Long value;

	public Long getValue() {
		return value;
	}

	public void setValue(Long value) {
		this.value = value;
	}
}
