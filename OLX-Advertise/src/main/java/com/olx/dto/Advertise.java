package com.olx.dto;

import java.time.LocalDate;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@ApiModel(value = "ADVERTISE DTO")
public class Advertise {

	@ApiModelProperty(value = "Id")
	private int id;

	@ApiModelProperty(value = "Title")
	private String title;

	@ApiModelProperty(value = "description")
	private String description;

	@ApiModelProperty(value = "price")
	private double price;

	@ApiModelProperty(value = "category_Id")
	private int categoryId;

	@ApiModelProperty(value = "category_name")
	private String category;

	@ApiModelProperty(value = "createdDate")
	private LocalDate createdDate;

	@ApiModelProperty(value = "modifiedDate")
	private LocalDate modifiedDate;

	@ApiModelProperty(value = "active")
	private String active;

	@ApiModelProperty(value = "username")
	private String username;

	public Advertise() {
		super();
	}

	public Advertise(int id, String title, String description, double price, int categoryId, String category,
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
		return "Advertise [id=" + id + ", title=" + title + ", description=" + description + ", price=" + price
				+ ", categoryId=" + categoryId + ", category=" + category + ", createdDate=" + createdDate
				+ ", modifiedDate=" + modifiedDate + ", active=" + active + ", username=" + username + "]";
	}

}
