package org.thanhtung.shop.moccat;

public class ItemOrderBean {
	public Item item;
	public int numItems;
	private double dblTotalCost;

	public ItemOrderBean(Item item) {
		setItem(item);
		setNumItems(1);
	}

	public Item getItem() {
		return (item);
	}

	public void setItem(Item item) {
		this.item = item;
	}

	public String getItemID() {
		return (getItem().getItemID());
	}

	public String getItemName() {
		return (getItem().getItemName());
	}

	public double getUnitCost() {
		return (getItem().getCost());
	}

	public int getNumItems() {
		return (numItems);
	}

	public void setNumItems(int n) {
		this.numItems = n;
	}

	// Xóa mặt hàng
	public int removeItem() {
		numItems = 0;
		setNumItems(numItems);
		return numItems;
	}

	public void cancelOrder() {
		setNumItems(0);
	}

	// tăng số lượng
	public void incrementNumItems() {
		setNumItems(getNumItems() + 1);
	}

	// tính tổng giá của một mặt hàng
	public double getTotalItemCost() {
		return (getNumItems() * getUnitCost());
	}
}
