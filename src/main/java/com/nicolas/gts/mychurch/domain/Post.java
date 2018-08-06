package com.nicolas.gts.mychurch.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Post implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String title;
	@Lob
	private String description;
	private String linkImage;
	private String linkVideo;
	
	@ManyToOne
	@JoinColumn(name="church_id")
	private Church church;
	
	public Post(){}
	

	public Post(Integer id, String title, String description, Church church) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.church = church;
	}

	public Post(Integer id, String title, String description, String linkImage, String linkVideo, Church church) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.linkImage = linkImage;
		this.linkVideo = linkVideo;
		this.church = church;
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
