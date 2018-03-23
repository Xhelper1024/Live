package com.dreamfly.entity;

import java.sql.Timestamp;

public class BlogNoticeDustbin {

	private int id;
	private int noticeId;
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BlogNoticeDustbin [id=" + id + ", noticeId=" + noticeId + ", createDate=" + createDate + "]";
	}

}
