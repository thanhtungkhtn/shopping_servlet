package org.thanhtung.shop.moccat;

import java.util.*;

public class CartBean {
	// Key Map = ID Item
	// user works with cart

	public Map<String, ItemOrderBean> itemsOrdered;

	private double dblOrderTotal;

	/** empty shopping cart. */

	public CartBean() {
		itemsOrdered = new HashMap<String, ItemOrderBean>();
	}

	public Map<String, ItemOrderBean> getCart() {
		// return itemsOrdered = new HashMap<String, ItemOrderBean>();
		return itemsOrdered;
	}

	public void setCart(Map<String, ItemOrderBean> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}

	public int getItemCount() {
		return itemsOrdered.size();
	}

	public double getOrderTotal() {
		return dblOrderTotal;
	}

	public void setOrderTotal(double dblOrderTotal) {
		this.dblOrderTotal = dblOrderTotal;
	}

	// -----------------------------------------------------//
	// user
	public synchronized void addItem(String itemID) {
		ItemOrderBean order;

		for (String key : itemsOrdered.keySet()) {
			order = (ItemOrderBean) itemsOrdered.get(key);
			if (key.equals(itemID)) {
				order.incrementNumItems();
				return;
			}
		}

		ItemOrderBean newOrder = new ItemOrderBean(ItemListImpl.search(itemID));
		itemsOrdered.put(itemID, newOrder);
	}

	// -------------------------//----------------------------//

	public synchronized void setNumOrdered(String itemID, int numOrdered) {
		ItemOrderBean order;

		for (String keyItemInCart : itemsOrdered.keySet()) { // key cua map chi de duyet
			order = (ItemOrderBean) itemsOrdered.get(keyItemInCart);
			if (keyItemInCart.equals(itemID)) {
				if (numOrdered <= 0) {
					itemsOrdered.remove(keyItemInCart);
				} else {
					order.setNumItems(numOrdered);
				}
				return;
			}
		}

		ItemOrderBean newOrder = new ItemOrderBean(ItemListImpl.search(itemID));
		itemsOrdered.put(itemID, newOrder);
	}

	// tÃ­nh chi phÃ­ cá»§a giá»�
	public synchronized double totalprices() {
		ItemOrderBean order;
		dblOrderTotal = 0;
		for (String key : itemsOrdered.keySet()) {
			order = (ItemOrderBean) itemsOrdered.get(key);

			dblOrderTotal = dblOrderTotal + order.getTotalItemCost();
		}

		return dblOrderTotal;
	}

	// ------------------------------------------//
	// user
	public void deleteCartItem(String itemID) {
		try {
			itemsOrdered.remove(itemID);
			// calculateOrderTotal(ItemOrderBean ordered);
		} catch (NumberFormatException nfe) {
			System.out.println("Error while deleting cart item: " + nfe.getMessage());
			nfe.printStackTrace();
		}
	}
	// -------------------------//----------------------------//
}
