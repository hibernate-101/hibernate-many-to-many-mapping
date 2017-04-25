package com.hibernate.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "TBL_CART")
public class CartAnnotation {
	@Id
	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "cart_total")
	private double total;

	@ManyToMany(targetEntity = ItemAnnotation.class, cascade = { CascadeType.ALL })
	@JoinTable(name = "CART_ITEMS", 
				joinColumns = { @JoinColumn(name = "cart_id") }, 
				inverseJoinColumns = { @JoinColumn(name = "item_id") })
	private Set<ItemAnnotation> items;

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the total
	 */
	public double getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(double total) {
		this.total = total;
	}

	/**
	 * @return the items
	 */
	public Set<ItemAnnotation> getItems() {
		return items;
	}

	/**
	 * @param items the items to set
	 */
	public void setItems(Set<ItemAnnotation> items) {
		this.items = items;
	}
	
	
	

}
