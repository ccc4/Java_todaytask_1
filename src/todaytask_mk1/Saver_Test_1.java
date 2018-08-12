package todaytask_mk1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class Saver_Test_1 {
	public static void main(String[] args) throws Exception {
		String dirName = "." + File.separator;
		String fileName = "content_test.txt";
		
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
										new FileOutputStream(file))));
		
		out.println("Hi");
		
		out.close();
		
	}
}
