package com.nicolas.gts.mychurch.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class PostEvent extends Post {

	private Date startDate;
	private Date endDate;

	public PostEvent() {
	}

	public PostEvent(Integer id, String title, String description, String linkImage, String linkVideo, Church church, Date startDate,
			Date endDate) {
		super(id, title, description, linkImage, linkVideo,church);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public PostEvent(Integer id, String title, String description, Church church, Date startDate, Date endDate) {
		super(id, title, description, church);
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
