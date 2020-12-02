package top.wlz922.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Apple implements Fruit {

	@Override
	public void showTaste() {
		log.info("Apple is sour and sweet.");
	}

	@Override
	public void seed(String type) {
		log.info("Apple seed type is {}.", type);
	}
}
