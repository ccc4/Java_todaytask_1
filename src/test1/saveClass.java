package test1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class saveClass {
	String[] inputStr;
	public saveClass(String getText) throws IOException {
//		inputStr = new String[1];
//		inputStr[0] = getText;
		
		String dirName = "." + File.separator;
		String fileName = "Test_1_Save.txt";
		
		File dir = new File(dirName);
		File file = new File(dir, fileName);
		
		if(!dir.exists()) {
			dir.mkdirs();
			if(!file.exists()) {
				file.createNewFile();
			}
		}
		
		PrintWriter out = 
				new PrintWriter(
						new BufferedWriter(
								new OutputStreamWriter(
										new FileOutputStream(file, true))), true);
		
		out.println(getText);
		
		out.close();
		
		
		
		
	}
}
