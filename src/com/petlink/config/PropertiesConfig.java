package com.petlink.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.petlink.exception.InternalServiceException;

public class PropertiesConfig {
	private static final Properties PROPERTIES = new Properties();
	private static final PropertiesConfig PROPERTIES_CONFIG = new PropertiesConfig();

	private PropertiesConfig() {
		try (BufferedReader bufferedReader1 = new BufferedReader(new FileReader("src\\resources\\database.properties"));
			 BufferedReader bufferedReader2 = new BufferedReader(new FileReader("src\\resources\\messages.properties"));) {
			PROPERTIES.load(bufferedReader1);
			PROPERTIES.load(bufferedReader2);
		} catch (IOException e) {
			throw new InternalServiceException("Failed to load " + e.getMessage());
		}
	}
	public static PropertiesConfig getInstance() {
		return PROPERTIES_CONFIG;
	}

	public String getProperty(String key) {
		return PROPERTIES.getProperty(key);
	}
}
