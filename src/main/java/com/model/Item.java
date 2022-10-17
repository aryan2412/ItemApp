package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name="findByPrice",query="select i from Item i where i.price=:price")
public class Item {

	
	
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", getQuantity=" + getQuantity
				+ "]";
	}
	public Item( String itemName, float price, int getQuantity) {
		super();
		this.itemName = itemName;
		this.price = price;
		this.getQuantity = getQuantity;
	}
	public Item(int itemId, String itemName, float price, int getQuantity) {
		super();
		this.itemId = itemId;
		this.itemName = itemName;
		this.price = price;
		this.getQuantity = getQuantity;
	}
	@Id
	@GeneratedValue
	private int itemId;
	private String itemName;
	private float price;
	private int getQuantity;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getGetQuantity() {
		return getQuantity;
	}
	public void setGetQuantity(int getQuantity) {
		this.getQuantity = getQuantity;
	}
	
}
