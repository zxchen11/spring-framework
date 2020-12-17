package top.wlz922.customano;

import lombok.Data;

import javax.annotation.PreDestroy;

/**
 * @author Eddie
 */
@Data
@CustomAno
public class CustomAnoBean {
	private String name = "Eddie";

	@PreDestroy
	public void destroyMethod(){
		System.out.println("CustomAnoBean destroyMethod");
	}
}
