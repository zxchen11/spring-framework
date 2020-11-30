package top.wlz922.aspect;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Slf4j
public class Apple {
	@Transactional
	public void showTaste(){
		log.info("Apple is sour and sweet.");
	}
}
