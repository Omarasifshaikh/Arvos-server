package com.arvos.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Augment {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	
	protected Augment() {}
	
	public Augment(String title) {
        this.title = title;
    }
	public Augment(String title, String description) {
        this.title = title;
        this.description = description;
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
	
	@Override
    public String toString() {
        return String.format(
                "Augment[id=%d, title='%s', description='%s']",
                id, title, description);
    }
	

}
