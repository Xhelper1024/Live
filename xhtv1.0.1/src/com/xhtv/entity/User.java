package com.xhtv.entity;

public class User {
	private String uid;
	private String pwd;
	private String nickname;
	private int balance;
	private boolean isLiver;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public boolean isLiver() {
		return isLiver;
	}

	public void setLiver(boolean isLiver) {
		this.isLiver = isLiver;
	}
}
