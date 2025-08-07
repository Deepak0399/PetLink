package com.petlink.util;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.petlink.dto.OwnerDTO;
import com.petlink.enums.Gender;
import com.petlink.enums.PetType;

public class MapperUtil {
	private MapperUtil() {

	}

	public static OwnerDTO convertOwnerResultSetToDto(ResultSet resultSet) throws SQLException {
		OwnerDTO owner = new OwnerDTO();
		owner.setId(resultSet.getInt("id"));
		owner.setFirstName(resultSet.getString("first_name"));
		owner.setLastName(resultSet.getString("last_name"));
		owner.setGender(Gender.valueOf(resultSet.getString("gender")));
		owner.setCity(resultSet.getString("city"));
		owner.setState(resultSet.getString("state"));
		owner.setMobileNumber(resultSet.getString("mobile_number"));
		owner.setEmailId(resultSet.getString("email_id"));
		owner.setPetId(resultSet.getInt("pet_id"));
		owner.setPetName(resultSet.getString("pet_name"));
		owner.setPetBirthDate(resultSet.getDate("pet_date_of_birth").toLocalDate());
		owner.setPetGender(Gender.valueOf(resultSet.getString("pet_gender")));
		owner.setPetType(PetType.valueOf(resultSet.getString("pet_type")));
		return owner;
	}
}
