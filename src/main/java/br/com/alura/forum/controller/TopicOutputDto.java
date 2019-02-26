package br.com.alura.forum.controller;

import java.time.Instant;

import br.com.alura.forum.model.topic.domain.Topic;

public class TopicOutputDto {

	
	private Long id;
	private String shortDescription;
	private String content;
	private Topic topic;
	private int numberOfResponses;
	private Instant creationInstant;
	private Instant lastUpdate;
	
	private String ownerName;
	private String courseName;
	private String subcategoryName;
	private String categoryName;
	
	public TopicOutputDto() {
		
	}

	
	public TopicOutputDto(Long id, String shortDescription, String content, Topic topic, int numberOfResponses,
			Instant creationInstant, Instant lastUpdate, String ownerName, String courseName, String subcategoryName,
			String categoryName) {
		this.id = id;
		this.shortDescription = shortDescription;
		this.content = content;
		this.topic = topic;
		this.numberOfResponses = numberOfResponses;
		this.creationInstant = creationInstant;
		this.lastUpdate = lastUpdate;
		this.ownerName = ownerName;
		this.courseName = courseName;
		this.subcategoryName = subcategoryName;
		this.categoryName = categoryName;
	}



	public TopicOutputDto(Topic topic2) {
	}


	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getShortDescription() {
		return shortDescription;
	}



	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
	}



	public Topic getTopic() {
		return topic;
	}



	public void setTopic(Topic topic) {
		this.topic = topic;
	}



	public int getNumberOfResponses() {
		return numberOfResponses;
	}



	public void setNumberOfResponses(int numberOfResponses) {
		this.numberOfResponses = numberOfResponses;
	}



	public Instant getCreationInstant() {
		return creationInstant;
	}



	public void setCreationInstant(Instant creationInstant) {
		this.creationInstant = creationInstant;
	}



	public Instant getLastUpdate() {
		return lastUpdate;
	}



	public void setLastUpdate(Instant lastUpdate) {
		this.lastUpdate = lastUpdate;
	}



	public String getOwnerName() {
		return ownerName;
	}



	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}



	public String getCourseName() {
		return courseName;
	}



	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}



	public String getSubcategoryName() {
		return subcategoryName;
	}



	public void setSubcategoryName(String subcategoryName) {
		this.subcategoryName = subcategoryName;
	}



	public String getCategoryName() {
		return categoryName;
	}



	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
