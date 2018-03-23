package com.dreamfly.entity;

import java.sql.Timestamp;

public class BlogUsers {

	private int id;
	private String nickname;
	private String headImg;
	private String sexy;
	private String email;
	private String password;
	private int exp;
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getHeadImg() {
		return headImg;
	}

	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}

	public String getSexy() {
		return sexy;
	}

	public void setSexy(String sexy) {
		this.sexy = sexy;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BlogUsers [id=" + id + ", nickname=" + nickname + ", headImg=" + headImg + ", sexy=" + sexy + ", email="
				+ email + ", password=" + password + ", exp=" + exp + ", createDate=" + createDate + "]";
	}

}
