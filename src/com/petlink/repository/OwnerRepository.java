package com.petlink.repository;

import java.util.List;

import com.petlink.dto.OwnerDTO;

public interface OwnerRepository {
	void saveOwner(OwnerDTO owner);

	OwnerDTO findOwner(int ownerId);

	void updatePetDetails(int ownerId, String petName);

	void deleteOwner(int ownerId);

	List<OwnerDTO> findAllOwners();
	
	List<OwnerDTO> updatePetDetails(String petType);
}
