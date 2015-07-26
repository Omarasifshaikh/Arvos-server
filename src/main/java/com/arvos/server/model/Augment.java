package com.arvos.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Augment {
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	@JsonIgnore
	private long id;

	private String arvosVersion;
	private String name;
	private String author;
	private String url;
	private double lat;
	private double lon;
	
	@JsonIgnore
	private double alt;
	
	@JsonIgnore
	private double radius;
	
	private String description;
	
	@JsonIgnore
	private String developerKey;
	
	private String category;
	
	//Constructors
	protected Augment() {}
	
	public Augment(String name) {
        this.name = name;
    }
	public Augment(String name, String description) {
        this.name = name;
        this.description = description;
    }
	
	public Augment(String arvosVersion, String name, String author, String url,
			double lat, double lon, double alt, double radius,
			String description, String category) {
		super();
		this.arvosVersion = arvosVersion;
		this.name = name;
		this.author = author;
		this.url = url;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.radius = radius;
		this.description = description;
		this.category = category;
	}

	//Getters and setters
	@JsonProperty
	public long getId() {
		return id;
	}
	
	@JsonIgnore
	public void setId(long id) {
		this.id = id;
	}
	
	public String getArvosVersion() {
		return arvosVersion;
	}

	public void setArvosVersion(String arvosVersion) {
		this.arvosVersion = arvosVersion;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLon() {
		return lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@JsonProperty
	public double getAlt() {
		return alt;
	}
	
	@JsonIgnore
	public void setAlt(double alt) {
		this.alt = alt;
	}

	@JsonProperty
	public double getRadius() {
		return radius;
	}

	@JsonIgnore
	public void setRadius(double radius) {
		this.radius = radius;
	}

	@JsonProperty
	public String getDeveloperKey() {
		return developerKey;
	}

	@JsonIgnore
	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	//TODO- Update Tostring.
	@Override
    public String toString() {
        return String.format(
                "Augment[id=%d, name='%s', description='%s']",
                id, name, description);
    }
}
