package com.automationpractice.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.automationpractice.constants.Constants;

public class PropertyReader {

	public Properties properties = new Properties();
	Properties allPages = new Properties();
	File fileObj;
	String filePath = null;

	public Properties readProperty(String filePath, String fileName) {

		try {
			FileInputStream stream = new FileInputStream(new File(filePath + fileName));
			properties.load(stream);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("File Input/Outout Exception");
		}
		return properties;
	}

	public Properties loadAllFiles() {
		fileObj = new File(Constants.PROPERTIES_PATH);
		filePath = Constants.PROPERTIES_PATH;
		File[] files = fileObj.listFiles();
		for (int file = 0; file < files.length; file++) {
			String fileName = files[file].getName();
			allPages = readProperty(filePath, fileName);
		}
		return allPages;
	}

}
