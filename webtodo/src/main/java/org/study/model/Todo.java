package org.study.model;

import java.sql.Date;

public class Todo {
	String idx;
	String userid;
	Date s_date;
	Date e_date;
	String memo;
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public Date getS_date() {
		return s_date;
	}
	public void setS_date(Date s_date) {
		this.s_date = s_date;
	}
	public Date getE_date() {
		return e_date;
	}
	public void setE_date(Date e_date) {
		this.e_date = e_date;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	@Override
	public String toString() {
		return "Todo [idx=" + idx + ", userid=" + userid + ", s_date=" + s_date + ", e_date=" + e_date + ", memo="
				+ memo + "]";
	}
	
	
}
