package com.obs.Accessory.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.obs.Accessory.domain.ItemAccessory;
import com.obs.Accessory.services.impl.ItemAccessoryServiceImpl;
import com.obs.Master.services.MasterService;

@Controller
public class ItemAccessoryController {
	
	private ItemAccessoryServiceImpl itemAccessoryServiceImpl;
	private MasterService masterService;
	
	@Autowired
	public ItemAccessoryController(ItemAccessoryServiceImpl itemAccessoryServiceImpl, MasterService masterService) {
		super();
		this.itemAccessoryServiceImpl = itemAccessoryServiceImpl;
		this.masterService = masterService;
	}
	
	@RequestMapping("/itemAccessory/create")
	public String itemCreate(Model model) {
		model.addAttribute("itemAccessory", new ItemAccessory());
		return "/itemAccessory/inputForm";
	}
	
	@RequestMapping(value = "/itemAccessory/save", method=RequestMethod.POST) 
	public String inputForm(@ModelAttribute("itemAccessory") ItemAccessory itemAccessory) {
		itemAccessory.setDeleteYN('N');
		itemAccessoryServiceImpl.save(itemAccessory);
		masterService.saveItemAccessory(itemAccessory);
		return "redirect:/itemAccessory/list"; 
	}
	
	@RequestMapping("/itemAccessory/list")
	public String item(Model model) {
		model.addAttribute("itemAccessories",itemAccessoryServiceImpl.list());
		return "itemAccessory/list";
	}
	
	@RequestMapping("/itemAccessory/edit/{id}")
	public String edit(@PathVariable Long id, Model model){
		model.addAttribute("itemAccessory", itemAccessoryServiceImpl.get(id));
		return "/itemAccessory/inputForm";		
	}
	
	@RequestMapping("/itemAccessory/delete/{id}")
	public String delete(@PathVariable Long id, Model model){
		itemAccessoryServiceImpl.deleteYN(id);
		masterService.delete(itemAccessoryServiceImpl.getProductId(id));
		return "redirect:/itemAccessory/list";		
	}
}
