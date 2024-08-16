package com.spring.sample.entity;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Micropost extends BaseEntity implements Serializable {

	private Integer id;
	private String content;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
