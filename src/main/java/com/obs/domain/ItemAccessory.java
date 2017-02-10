package com.obs.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ItemAccessory")
public class ItemAccessory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7807666512674286064L;

	@Id
	@GeneratedValue
	@Column(name="item_accessory_id")
	private Long itemAccessoryId;
	
	@Column(name="product_id")
	private String productId;
	
	@Column(name="product_name")
	private String productName;
	
	@Column(name="purchase_price")
	private double purchasePrice;
	
	@Column(name="sales_price")
	private double salesPrice;
	
	@Column(name="acc_length")
	private double accLength;
	
	@Column(name="acc_height")
	private double accHeight;
	
	@Column(name="acc_width")
	private double accWidth;
	
	@Column(name="acc_weight")
	private double accWeight;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="accessory_inventory_id")
	private AccessoryInventory accessoryInventory;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="itemAccessory")
	private Set<ReceivedQuantity> receivedQuantity;
	
	public ItemAccessory() {}

	public ItemAccessory(Long itemAccessoryId, String productId, String productName, double purchasePrice,
			double salesPrice, double accLength, double accHeight, double accWidth, double accWeight,
			AccessoryInventory accessoryInventory, Set<ReceivedQuantity> receivedQuantity) {
		super();
		this.itemAccessoryId = itemAccessoryId;
		this.productId = productId;
		this.productName = productName;
		this.purchasePrice = purchasePrice;
		this.salesPrice = salesPrice;
		this.accLength = accLength;
		this.accHeight = accHeight;
		this.accWidth = accWidth;
		this.accWeight = accWeight;
		this.accessoryInventory = accessoryInventory;
		this.receivedQuantity = receivedQuantity;
	}

	public Long getItemAccessoryId() {
		return itemAccessoryId;
	}

	public void setItemAccessoryId(Long itemAccessoryId) {
		this.itemAccessoryId = itemAccessoryId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPurchasePrice() {
		return purchasePrice;
	}

	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
	}

	public double getSalesPrice() {
		return salesPrice;
	}

	public void setSalesPrice(double salesPrice) {
		this.salesPrice = salesPrice;
	}

	public double getAccLength() {
		return accLength;
	}

	public void setAccLength(double accLength) {
		this.accLength = accLength;
	}

	public double getAccHeight() {
		return accHeight;
	}

	public void setAccHeight(double accHeight) {
		this.accHeight = accHeight;
	}

	public double getAccWidth() {
		return accWidth;
	}

	public void setAccWidth(double accWidth) {
		this.accWidth = accWidth;
	}

	public double getAccWeight() {
		return accWeight;
	}

	public void setAccWeight(double accWeight) {
		this.accWeight = accWeight;
	}

	public AccessoryInventory getAccessoryInventory() {
		return accessoryInventory;
	}

	public void setAccessoryInventory(AccessoryInventory accessoryInventory) {
		this.accessoryInventory = accessoryInventory;
	}

	public Set<ReceivedQuantity> getReceivedQuantity() {
		return receivedQuantity;
	}

	public void setReceivedQuantity(Set<ReceivedQuantity> receivedQuantity) {
		this.receivedQuantity = receivedQuantity;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
