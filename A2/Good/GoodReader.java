package com.dalhousie;

public class GoodReader {
	
	public void readFile(IFileReader iFileReader, String filePath) {
		iFileReader.read(filePath);
	}
}
