package com.petlink.service;

import java.util.List;

import com.petlink.dto.OwnerDTO;
import com.petlink.enums.PetType;
import com.petlink.exception.DuplicateOwnerException;
import com.petlink.exception.OwnerNotFoundException;


public interface OwnerService {
	void saveOwner(OwnerDTO ownerDTO) throws DuplicateOwnerException;

	OwnerDTO findOwner(int ownerId) throws OwnerNotFoundException;

	void updatePetDetails(int ownerId, String petName) throws OwnerNotFoundException;

	void deleteOwner(int ownerId) throws OwnerNotFoundException;

	List<OwnerDTO> findAllOwners();

	List<OwnerDTO> updatePetDetails(PetType petType);
}