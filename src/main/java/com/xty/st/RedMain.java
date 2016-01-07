package com.xty.st;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xty.st.task.RedTask;

public class RedMain {
	private static Logger logger = LoggerFactory.getLogger(RedMain.class);
	private static Logger red = LoggerFactory.getLogger("red.log");
	public static void main(String args[]) {

		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"spring.xml");
		try {
			red.info("======= Task Begin");
			ctx.getBean(RedTask.class).findYesterdayFinishOrdersThenSendReds();
			red.info("======= Task End");
			
		} catch (Exception e) {
			logger.error("错误",e);
		}
	}
}
