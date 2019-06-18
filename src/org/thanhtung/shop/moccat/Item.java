package org.thanhtung.shop.moccat;

public class Item {
	public String itemID;
	public double cost;
	public String itemName;
	public String imagePath;
	

	public Item(String itemID, String itemName,String imagePath, double cost) {
		setItemID(itemID);
		setImagePath(imagePath);
		setCost(cost);
		setItemName(itemName);
	}

	public String getItemID() {
		return (itemID);
	}

	public String getItemName() {
		return (itemName);
	}

	public double getCost() {
		return (cost);
	}
	
	public String getImagePath() {
		return (imagePath);
	}

	
	public void setItemID(String itemID) {
		this.itemID = itemID;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
}
