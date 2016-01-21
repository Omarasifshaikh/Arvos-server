package com.arvos.server.model;

import java.net.URI;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Need to build the Directory information as per the specification...
 * Controllers are to be added with security...
 * 
 * @author omar
 *
 */

@Entity
@Table(name = "directories")
public class Directory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String arvosVersion;
	private String name;
	private String author;
	private String url;
	private double lat;
	private double lon;
	
	private double alt;
	
	private double radius;
	
	private String description;
	
	private String developerKey;
	
	private String category;

	public long getId() {
		return id;
	}

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

	public double getAlt() {
		return alt;
	}

	public void setAlt(double alt) {
		this.alt = alt;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDeveloperKey() {
		return developerKey;
	}

	public void setDeveloperKey(String developerKey) {
		this.developerKey = developerKey;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Directory() {
		super();
	}
	
	public Directory(String name) {
		super();
		this.name = name;
	}

	public Directory(long id, String arvosVersion, String name, String author, String url, double lat, double lon,
			double alt, double radius, String description, String developerKey, String category) {
		super();
		this.id = id;
		this.arvosVersion = arvosVersion;
		this.name = name;
		this.author = author;
		this.url = url;
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
		this.radius = radius;
		this.description = description;
		this.developerKey = developerKey;
		this.category = category;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		return "Directory [arvosVersion=" + arvosVersion + ", name=" + name + ", author=" + author + ", url=" + url
				+ ", lat=" + lat + ", lon=" + lon + ", alt=" + alt + ", radius=" + radius + ", description="
				+ description + ", category=" + category + "]";
	}

	
	
}

//TODO - Establish a one to many relationship between directory and augments...
