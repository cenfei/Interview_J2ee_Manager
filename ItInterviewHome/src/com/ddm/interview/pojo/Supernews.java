package com.ddm.interview.pojo;

import java.util.Date;

/**
 * Accountinfo entity. @author MyEclipse Persistence Tools
 */

public class Supernews implements java.io.Serializable {

	// Fields

	private Long id;
	private String title;
	private  String content;
	private String picUrl;
	private  Date createTimeDate;
	private String picUrlArray;
	public String getPicUrlArray() {
		return picUrlArray;
	}
	public void setPicUrlArray(String picUrlArray) {
		this.picUrlArray = picUrlArray;
	}
	public Date getShowTimeDate() {
		return showTimeDate;
	}
	public void setShowTimeDate(Date showTimeDate) {
		this.showTimeDate = showTimeDate;
	}
	private  Date showTimeDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPicUrl() {
		return picUrl;
	}
	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}
	public void setCreateTimeDate(Date createTimeDate) {
		this.createTimeDate = createTimeDate;
	}
	public Date getCreateTimeDate() {
		return createTimeDate;
	}
	
}