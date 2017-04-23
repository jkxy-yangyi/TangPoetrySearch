package com.jkxy.entity;

import java.util.Date;

public class Poetries {
	private Integer id;
	private Integer poet_id;	//诗歌ID
	private String content;	//诗歌内容
	private String title;	//诗歌标题
	private Date created_at;  //诗歌创建时间
	private Date updated_at;		//更新时间
	private String name;  //作者
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPoet_id() {
		return poet_id;
	}
	public void setPoet_id(Integer poet_id) {
		this.poet_id = poet_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
