package org.bran.branroom.dto;

import java.time.LocalDateTime;

import org.bran.branroom.entity.Blog;
import static org.bran.branroom.utils.BlogUtil.*;

public class PreviewBlog {

	private int id;
	
	private String title;
	
	private String pretext;
	
	private String author;
	
	private LocalDateTime posttime;

	public PreviewBlog(Blog b){
		setId(b.getId());
		setTitle(b.getTitle());
		setAuthor(b.getAuthor());
		setPretext(b.getContent());
		setPosttime(b.getPosttime());
		
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

	public String getPretext() {
		return pretext;
	}

	public void setPretext(String pretext) {
		
		this.pretext = limitSize(removeTag(pretext), 50);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public LocalDateTime getPosttime() {
		return posttime;
	}

	public void setPosttime(LocalDateTime posttime) {
		this.posttime = posttime;
	}
	
	
	
}
