package top.wlz922.test.context;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.wlz922.bean.Dog;
import top.wlz922.bean.DogFactory;

@Slf4j
public class ApplicationContextTest {

	@Test
	public void testClassPathXmlApplicationContext() {
		// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext();
		// context.setAllowBeanDefinitionOverriding(true);
		// context.setConfigLocation("spring1.xml");
		// context.refresh();
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring1.xml");
		Dog dog = context.getBean("dog", Dog.class);
		DogFactory dogOfFactory = context.getBean("lookupDogFactory", DogFactory.class);
		log.debug(dog.toString());
		log.debug(dogOfFactory.getDog().toString());

		Dog dogReplacer = context.getBean("dogReplacer", Dog.class);
		log.debug(dogReplacer.toString());
	}
}
