package com.obs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.obs.domain.AccessoryReceivedQuantity;
import com.obs.repositories.AccessoryReceivedQuantityRepository;

@Service
public class AccessoryReceivedQuantityService {
		@Autowired
		private AccessoryReceivedQuantityRepository accessoryReceivedQuantityRepository;
		
		public AccessoryReceivedQuantityService(AccessoryReceivedQuantityRepository accessoryReceivedQuantityRepository) {
			this.accessoryReceivedQuantityRepository = accessoryReceivedQuantityRepository;
		}
		
		public List<AccessoryReceivedQuantity> list() {
			return accessoryReceivedQuantityRepository.findByOrderByReceivedDate();
		}
		
		public AccessoryReceivedQuantity save(AccessoryReceivedQuantity accessoryReceivedQuantity) {
			return accessoryReceivedQuantityRepository.save(accessoryReceivedQuantity);
		}
}
