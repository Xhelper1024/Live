package com.dreamfly.entity;

import java.sql.Timestamp;

public class BlogNotice {

	private int id;
	private int uid;
	private String noticeContent;
	private int noticeState;
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public int getNoticeState() {
		return noticeState;
	}

	public void setNoticeState(int noticeState) {
		this.noticeState = noticeState;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BlogNotice [id=" + id + ", uid=" + uid + ", noticeContent=" + noticeContent + ", noticeState="
				+ noticeState + ", createDate=" + createDate + "]";
	}

}
