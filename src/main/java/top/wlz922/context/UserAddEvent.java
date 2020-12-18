package top.wlz922.context;

import org.springframework.context.ApplicationEvent;

/**
 * @author Eddie
 */
public class UserAddEvent extends ApplicationEvent {
	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public UserAddEvent(UserEventVo source) {
		super(source);
	}
}
