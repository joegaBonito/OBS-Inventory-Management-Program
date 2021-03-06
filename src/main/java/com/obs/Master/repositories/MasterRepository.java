package com.obs.Master.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.obs.Accessory.domain.ItemAccessory;
import com.obs.Master.domain.Master;

@Repository
public interface MasterRepository extends CrudRepository<Master,Long> {
	@Query("SELECT m FROM Master m where m.deleteYN = 'N'")
	List<Master> findByDeleteYN();
	@Query("SELECT m FROM Master m where m.deleteYN = 'N' ORDER BY productId")
	List<Master> findByDeleteYNOrderByProductId();
	List<Master> findByOrderById();
	Master findByProductId(String productId);
	void save(ItemAccessory itemAccessory);
}
