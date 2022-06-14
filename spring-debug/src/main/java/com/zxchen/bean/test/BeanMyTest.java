package com.zxchen.bean.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @className:
 * @description:
 * @author: zxchen11
 * @create: 2022-06-14 13:56
 **/
public class BeanMyTest {

	private String beanStr = "beanMyTest";

	public String getBeanStr() {
		return beanStr;
	}

	public void setBeanStr(String beanStr) {
		this.beanStr = beanStr;
	}

	public static void main(String[] args) {

		BeanFactory bf = new ClassPathXmlApplicationContext("beanTestFactory.xml");
		BeanMyTest beanMyTest = (BeanMyTest) bf.getBean("beanMyTest");
		System.out.println("beanStr:" + beanMyTest.getBeanStr());
	}
}
