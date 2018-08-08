package com.nicolas.gts.mychurch.dto;

import java.io.Serializable;

import com.nicolas.gts.mychurch.domain.Post;

public class PostDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private Integer id;
	private String title;
	private String description;
	private String linkImage;
	private String linkVideo;
	
	
	public PostDTO() {}
	
	public PostDTO(Post obj) {
		this.title = obj.getTitle();
		this.id = obj.getId();
		this.description = obj.getDescription();
		this.linkImage = obj.getLinkImage();
		this.linkVideo = obj.getLinkVideo();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getLinkImage() {
		return linkImage;
	}


	public void setLinkImage(String linkImage) {
		this.linkImage = linkImage;
	}


	public String getLinkVideo() {
		return linkVideo;
	}


	public void setLinkVideo(String linkVideo) {
		this.linkVideo = linkVideo;
	}
	
	

}
