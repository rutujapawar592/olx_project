package com.olx.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "ADVERTISES")
public class AdvertiseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int id;
	private String title;
	private String description;
	private double price;
	private int categoryId;
	private String category;

	@Column(name = "created_date")
	private LocalDate createdDate;

	@Column(name = "modified_date")
	private LocalDate modifiedDate;

	private String active;

	@Column(name = "username")
	private String username;

	public AdvertiseEntity() {
		super();
	}

	public AdvertiseEntity(int id, String title, String description, double price, int categoryId, String category,
			LocalDate createdDate, LocalDate modifiedDate, String active, String username) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.categoryId = categoryId;
		this.category = category;
		this.createdDate = createdDate;
		this.modifiedDate = modifiedDate;
		this.active = active;
		this.username = username;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public LocalDate getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDate modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getActive() {
		return active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public String toString() {
		return "AdvertiseEntity [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", categoryId=" + categoryId + ", category=" + category + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", active=" + active + ", username=" + username + "]";
	}

}
