package com.obs.Master.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obs.Master.domain.Master;
import com.obs.Master.repositories.MasterRepository;

@Service
public class MasterService {
	
	private MasterRepository masterRepository;
	
	@Autowired
	public MasterService(MasterRepository masterRepository) {
		this.masterRepository = masterRepository;
	}
	
	public void add(Master master) {
		masterRepository.save(master);
	}
	
	public void delete(String productId) {
		Master m = masterRepository.findByProductId(productId);
		m.setDeleteYN('Y');
		add(m);
	}
	
	public List<Master> list () {
		return masterRepository.findByDeleteYN();
	}
	
	
	/*
	 * Retrieves the grand total of every product's total purchased amount on /master/index.html 
	 */
	public double getGrandTotalPurchasedAmount() {
		double temp = 0;
		for(Master master : list()) {
			if(master.getAccessory() != null) {
				temp += master.getAccessory().getAccessoryInventory().getTotalPurchasedAmount();
			} else {
				temp += master.getPhone().getUnlockedPhonesInventory().getTotalPurchasedAmount();
			}
		}
		return temp;
	}
	
	/*
	 * Retrieves the grand total of every product's total purchased quantity on /master/index.html 
	 */
	public int getGrandTotalPurchasedQuantity() {
		int temp = 0;
		for(Master master : list()) {
			if(master.getAccessory() != null) {
				temp += master.getAccessory().getAccessoryInventory().getTotalPurchasedQuantity();
			} else {
				temp += master.getPhone().getUnlockedPhonesInventory().getTotalPurchasedQuantity();
			}
		}
		return temp;
	}
	
	/*
	 * Retrieves the grand total of every product's total sales amount on /master/index.html 
	 */
	public double getGrandTotalSalesAmount() {
		double temp = 0;
		for(Master master : list()) {
			if(master.getAccessory() != null) {
				temp += master.getAccessory().getAccessoryInventory().getSalesAmount();
			} else {
				temp += master.getPhone().getUnlockedPhonesInventory().getSalesAmount();
			}
		}
		return temp;
	}
	
	/*
	 * Retrieves the grand total of every product's total sales quantity on /master/index.html 
	 */
	public int getGrandTotalSalesQuantity() {
		int temp = 0;
		for(Master master : list()) {
			if(master.getAccessory() != null) {
				temp += master.getAccessory().getAccessoryInventory().getSalesQuantity();
			} else {
				temp += master.getPhone().getUnlockedPhonesInventory().getSalesQuantity();
			}
		}
		return temp;
	}
	
	/*
	 * Retrieves the grand total of every product's total current inventory on /master/index.html 
	 */
	public int getGrandTotalCurrentInventory() {
		int temp = 0;
		for(Master master : list()) {
			if(master.getAccessory() != null) {
				temp += master.getAccessory().getAccessoryInventory().getCurrentInventory();
			} else {
				temp += master.getPhone().getUnlockedPhonesInventory().getCurrentInventory();
			}
		}
		return temp;
	}
	
	/*
	 * Retrieves the grand total of every product's total current amount on /master/index.html 
	 */
	
	public double getGrandTotalCurrentInventoryAmount() {
		double temp = 0;
		for(Master master : list()) {
			if(master.getAccessory() != null) {
				temp += (master.getAccessory().getAccessoryInventory().getCurrentInventory() * master.getAccessory().getPurchasePrice());
			} else {
				temp += (master.getPhone().getUnlockedPhonesInventory().getCurrentInventory() * master.getPhone().getPurchasePrice());
			}
		}
		return temp;
	}

	public Master getMasterById(long id) {
		return masterRepository.findOne(id);
	}


	
}