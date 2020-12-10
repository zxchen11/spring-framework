package top.wlz922.annoboot;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

@HandlesTypes(MyWebApplicationInitializer.class)
public class MyServletContainerInitializer implements ServletContainerInitializer {
	public MyServletContainerInitializer() {
		System.out.println("MyServletContainerInitializer创建了");
	}

	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		if (c == null){
			return;
		}
		for (Class<?> aClass : c) {
			System.out.println(aClass.getName());
		}
	}
}
