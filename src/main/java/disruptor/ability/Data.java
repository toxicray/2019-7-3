package disruptor.ability;

import java.io.Serializable;

/**
 * Package:disruptor.ability
 * *Author:ray
 * *version:...
 * *Created in 2020/4/23  23:37
 **/
public class Data implements Serializable {

	private Long id;

	private String name;

	public Data(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
