package top.wlz922.tx;

import org.springframework.context.ApplicationEvent;

public abstract class AbstractCustomApplicationEvent<T> extends ApplicationEvent {

	public AbstractCustomApplicationEvent(T source) {
		super(source);
	}

	abstract void process();
}
