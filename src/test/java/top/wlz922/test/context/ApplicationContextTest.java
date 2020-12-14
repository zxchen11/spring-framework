package top.wlz922.test.context;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.wlz922.bean.Dog;
import top.wlz922.bean.DogFactory;
import top.wlz922.bean.Fruit;
import top.wlz922.customano.CustomAnoBean;
import top.wlz922.cyclic.CyclicGoodsService;
import top.wlz922.cyclic.CyclicOrderService;
import top.wlz922.test.config.AspectAnoConfiguration;
import top.wlz922.test.config.CustomAnoConfiguration;

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

	@Test
	public void testCyclicDependence(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("top.wlz922.cyclic");
		CyclicGoodsService goodsService = context.getBean(CyclicGoodsService.class);
		CyclicOrderService orderService = context.getBean(CyclicOrderService.class);
		log.debug(goodsService.toString());
		log.debug(orderService.toString());
	}

	@Test
	public void testAnoAop(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AspectAnoConfiguration.class);
		Fruit apple = context.getBean(Fruit.class);
		apple.showTaste();
		// apple.seed("hello world");
	}

	@Test
	public void testCustomAno(){
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(CustomAnoConfiguration.class);
		CustomAnoBean bean = context.getBean(CustomAnoBean.class);
		System.out.println(bean.getName());
	}
}
