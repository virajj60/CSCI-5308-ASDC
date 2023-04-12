package com.dalhousie;

public class BadReader {
	
	public void readFile(String filePath) {
	    BadCharReader br = new BadCharReader();
	    br.read(filePath);
	}
}
