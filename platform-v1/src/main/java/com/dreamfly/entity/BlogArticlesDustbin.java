package com.dreamfly.entity;

import java.sql.Timestamp;

public class BlogArticlesDustbin {

	private int id;
	private int articleId;
	private Timestamp createDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getArticleId() {
		return articleId;
	}

	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BlogArticlesDustbin [id=" + id + ", articleId=" + articleId + ", createDate=" + createDate + "]";
	}

}
