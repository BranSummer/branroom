package org.bran.branroom.entity;

import java.time.LocalDateTime;

public class Blog {
	private int id;
	private String title;
	private String author;
	private String content;
	private LocalDateTime posttime;
	
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

	
	public static void main(String[] args) {
		LocalDateTime t=LocalDateTime.now();
		System.out.println(t);
	}
	
}
