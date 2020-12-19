package top.wlz922.test.context;

import org.junit.Test;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import top.wlz922.context.UserAddEvent;
import top.wlz922.context.UserEventVo;

public class EventAndListenerTest {
	private final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();

	@Test
	public void testUserAddEvent(){
		// 这里的泛型一定要定义，spring在发布事件后调用监听器，就是通过泛型来确认一个监听器是否支持这个事件的。
		context.addApplicationListener(new ApplicationListener<UserAddEvent>() {
			@Override
			public void onApplicationEvent(UserAddEvent event) {
				System.out.println(event);
			}
		});
		context.addApplicationListener(new ApplicationListener<ContextRefreshedEvent>() {
			@Override
			public void onApplicationEvent(ContextRefreshedEvent event) {
				System.out.println("容器刷新完毕！！！");
			}
		});
		context.refresh();
		final UserEventVo userEventVo = new UserEventVo();
		userEventVo.setUserId(1);
		userEventVo.setUsername("Eddie");
		userEventVo.setPassword("123456");
		final UserAddEvent userAddEvent = new UserAddEvent(userEventVo);
		context.publishEvent(userAddEvent);

	}
}
