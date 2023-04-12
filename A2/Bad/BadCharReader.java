package com.dalhousie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class BadCharReader {
	
	//method reads the file, character by character
	public void read(String filePath) {
		File file = new File(filePath);
		try {
			FileReader filereader = new FileReader(file);
			BufferedReader buffReader = new BufferedReader(filereader);
			int n = 0;
			while ((n = buffReader.read()) != -1) {
				char character = (char) n;
				//perform operations on each read character
				System.out.println(character);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}