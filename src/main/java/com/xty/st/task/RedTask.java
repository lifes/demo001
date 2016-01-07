package com.xty.st.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xty.st.service.RedService;

@Component
public class RedTask {
	@Autowired
	private RedService redService;
	public void findYesterdayFinishOrdersThenSendReds(){
		redService.findYesterdayFinishOrdersThenSendReds();
	}
}
