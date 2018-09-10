package org.bran.branroom.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

public class Blog implements Serializable {
	private int id;
	private String title;
	private String author;
	private String content;
	private LocalDateTime posttime;
	private LocalDateTime updatetime;
	private List<String> keywords;


	public LocalDateTime getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(LocalDateTime updatetime) {
		this.updatetime = updatetime;
	}

	public LocalDateTime getPosttime() {
		return posttime;
	}
	public void setPosttime(LocalDateTime postTime) {
		this.posttime = postTime;
	}
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	
	
}
