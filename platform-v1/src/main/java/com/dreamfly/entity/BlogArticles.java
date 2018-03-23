package com.dreamfly.entity;

import java.sql.Timestamp;

public class BlogArticles {

	private int id;
	private int uid;
	private String articleTitle;
	private String articleContent;
	private int articleState;
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

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}

	public int getArticleState() {
		return articleState;
	}

	public void setArticleState(int articleState) {
		this.articleState = articleState;
	}

	public Timestamp getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "BlogArticles [id=" + id + ", uid=" + uid + ", articleTitle=" + articleTitle + ", articleContent="
				+ articleContent + ", articleState=" + articleState + ", createDate=" + createDate + "]";
	}

}
