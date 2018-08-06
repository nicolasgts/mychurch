package com.nicolas.gts.mychurch.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PostArticle extends Post {
	
	private String category;
	private String autor;
	private Date postDate;
	
	public PostArticle() {}

	public PostArticle(Integer id, String title, String description, String linkImage, String linkVideo, Church church, String category, String autor, Date postDate) {
		super(id, title, description, linkImage, linkVideo,church);
		this.category = category;
		this.autor = autor;
		this.postDate = postDate;
	}

	public PostArticle(Integer id, String title, String description, Church church, String category, String autor, Date postDate) {
		super(id, title, description,church);
		this.category = category;
		this.autor = autor;
		this.postDate = postDate;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Date getPostDate() {
		return postDate;
	}

	public void setPostDate(Date postDate) {
		this.postDate = postDate;
	}
	
	
	
	
	
	
	

}
