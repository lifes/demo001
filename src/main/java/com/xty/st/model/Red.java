package com.xty.st.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class Red implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long id;
	private Long user_id;
	private String red_name;
	private String red_desc;
	private Timestamp starttime;
	private Timestamp endtime;
	private int is_effective;
	private int is_used;
	private int red_type;
	private BigDecimal red_reduce;
	private int red_projectcount;
	
	public Red(){
		
	}
	public Red(Long id, Long user_id, String red_name, String red_desc,
			Timestamp starttime, Timestamp endtime, int is_effective,
			int is_used, int red_type, BigDecimal red_reduce,
			int red_projectcount) {
		this.user_id = user_id;
		this.red_name = red_name;
		this.red_desc = red_desc;
		this.starttime = starttime;
		this.endtime = endtime;
		this.is_effective = is_effective;
		this.is_used = is_used;
		this.red_type = red_type;
		this.red_reduce = red_reduce;
		this.red_projectcount = red_projectcount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public String getRed_name() {
		return red_name;
	}

	public void setRed_name(String red_name) {
		this.red_name = red_name;
	}

	public String getRed_desc() {
		return red_desc;
	}

	public void setRed_desc(String red_desc) {
		this.red_desc = red_desc;
	}

	public Timestamp getStarttime() {
		return starttime;
	}

	public void setStarttime(Timestamp starttime) {
		this.starttime = starttime;
	}

	public Timestamp getEndtime() {
		return endtime;
	}

	public void setEndtime(Timestamp endtime) {
		this.endtime = endtime;
	}

	public int getIs_effective() {
		return is_effective;
	}

	public void setIs_effective(int is_effective) {
		this.is_effective = is_effective;
	}

	public int getIs_used() {
		return is_used;
	}

	public void setIs_used(int is_used) {
		this.is_used = is_used;
	}

	public int getRed_type() {
		return red_type;
	}

	public void setRed_type(int red_type) {
		this.red_type = red_type;
	}

	public BigDecimal getRed_reduce() {
		return red_reduce;
	}

	public void setRed_reduce(BigDecimal red_reduce) {
		this.red_reduce = red_reduce;
	}

	public int getRed_projectcount() {
		return red_projectcount;
	}

	public void setRed_projectcount(int red_projectcount) {
		this.red_projectcount = red_projectcount;
	}
}
