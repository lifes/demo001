package com.xty.st.service.impl;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import com.xty.st.mapper.OrderMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xty.common.TimeUtil;
import com.xty.st.mapper.RedMapper;
import com.xty.st.model.Red;
import com.xty.st.service.RedService;

@Service
public class RedServiceImpl implements RedService {
	@Autowired
	private RedMapper redMapper;
	@Autowired
	private OrderMapper orderMapper;

	private Logger logger = LoggerFactory.getLogger("red.log");

	@Override
	@Transactional
	public void findYesterdayFinishOrdersThenSendReds() {
		Timestamp today = TimeUtil.getToday();
		Timestamp yesterday = TimeUtil.addDays(today, -1);
		List<Long> user_ids = orderMapper.getUseridsYesterdayFinishOrders(
				yesterday, today);
		logger.info("查询到{}个昨日已完成订单, 开始赠送", user_ids.size());

		for (Long user_id : user_ids) {
			// 赠送20元代金券
			Red red1 = new Red();
			red1.setUser_id(user_id);
			red1.setRed_name("20元代金券");
			red1.setStarttime(today);
			red1.setEndtime(TimeUtil.addDays(today, 7));
			red1.setRed_type(1);
			red1.setRed_desc("现金红包，使用立减二十元");
			red1.setRed_reduce(new BigDecimal("20.00"));
			red1.setIs_effective(1);
			red1.setIs_used(0);
			//
			Red red2 = new Red();
			red2.setUser_id(user_id);
			red2.setRed_name("30元套餐体验券");
			red2.setStarttime(today);
			red2.setEndtime(TimeUtil.addDays(today, 7));
			red2.setRed_type(2);
			red2.setRed_desc("项目大于两个可以使用");
			red2.setRed_projectcount(2);
			red2.setRed_reduce(new BigDecimal("30.00"));
			red2.setIs_effective(1);
			red2.setIs_used(0);
			redMapper.insertRed(red1);
			redMapper.insertRed(red2);
		}

		logger.info("共赠送{}红包, 赠送结束", user_ids.size()*2L);
	}
}
