package top.wlz922.bean;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Eddie
 */
@Data
@Slf4j
// @Component
public class Dog {
	private String name;
	private String color;

	public Dog() {
		System.out.println("初始化Dog");
	}

}
