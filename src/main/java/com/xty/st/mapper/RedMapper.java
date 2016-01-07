package com.xty.st.mapper;

import java.util.List;
import com.xty.st.model.Red;

public interface RedMapper {
	
	List<Red> getRedsByUserid(Long user_id);
	void insertRed(Red red);
}
