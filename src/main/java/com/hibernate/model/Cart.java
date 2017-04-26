package com.hibernate.model;

import java.util.Set;

public class Cart {
	private long id;
	private double total;
	Set<Item> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Set<Item> getItems() {
		return items;
	}

	public void setItems(Set<Item> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cart [id=" + id + ", total=" + total + "]";
	}
	

}
