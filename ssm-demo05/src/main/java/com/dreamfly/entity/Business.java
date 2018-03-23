package com.dreamfly.entity;

/**
 * 商家实体
 * 
 * @author 先生
 *
 */
public class Business {
	private int id;
	private String title;
	private String url;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Business() {
	}

	@Override
	public String toString() {
		return "Business [id=" + id + ", title=" + title + ", url=" + url + "]";
	}

}
