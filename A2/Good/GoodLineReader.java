package com.dalhousie;

import java.io.BufferedReader;
import java.io.IOException;

public class GoodLineReader implements IFileReader {

	@Override
	public void read(String filePath) {
		StringBuilder sb = new StringBuilder();
		try {
			BufferedReader buffer = new BufferedReader(new java.io.FileReader(filePath));
			String str;
			while ((str = buffer.readLine()) != null) {
				sb.append(str);
			}
			System.out.println(sb);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
