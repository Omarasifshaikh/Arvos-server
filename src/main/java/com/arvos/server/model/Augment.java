package com.arvos.server.model;

public class Augment {
	
	private long id;
	private String title;
	private String description;
	
	public Augment(long id, String title) {
        this.id = id;
        this.title = title;
    }
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	

}
