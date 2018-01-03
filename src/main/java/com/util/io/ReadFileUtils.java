package com.util.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadFileUtils {
	
	public static String readTxt(String filePath){
		File file = new File(filePath);
		try {
			InputStreamReader iStreamReader = new InputStreamReader(new FileInputStream(file));
			BufferedReader reader = new BufferedReader(iStreamReader);
			String line = null;
			String result = null;
			while ((line = reader.readLine()) != null) {
				result += line;
			}
			return result;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}  catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
