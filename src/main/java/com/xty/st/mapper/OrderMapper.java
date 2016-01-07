package com.xty.st.mapper;

import java.sql.Timestamp;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface OrderMapper {
	@Select("select user_id from xty_massage_precontract where stop_server_time between #{start} and #{end} and stop_server_time != #{start}")
	List<Long> getUseridsYesterdayFinishOrders(@Param("start") Timestamp start, @Param("end") Timestamp end);
}
