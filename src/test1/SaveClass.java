package test1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;

public class SaveClass {
	String dirName = "." + File.separator;
	String fileName = "Test_1_Save.txt";
	File dir = new File(dirName);
	File file = new File(dir, fileName);
	
	LinkedList<String> aTrain;
	
	ObjectInputStream in;
	
	public SaveClass() throws IOException, ClassNotFoundException {
		
		// 파일 없을 시 생성
		if(!dir.exists()) {
			dir.mkdirs();
			if(!file.exists()) {
				file.createNewFile();
			}
		}
		
		// 오브젝트 불러오기. 없을 시에 새로 만들고 있으면 불러와서 변수지정.
		in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(file)));
		
		if(!in.readBoolean()) {
			aTrain = new LinkedList<>();
		} else {
			aTrain = (LinkedList<String>) in.readObject();
		}
	}
	
	public void saver(String getText) throws FileNotFoundException, IOException {
		String[] inputStr = new String[1];
		// 매개변수 받아서 train 에 저장
		inputStr[0] = getText;
		aTrain.add(inputStr[0]);
		
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		out.writeObject(aTrain);
		
		out.close();
		in.close();
	}
	
	public LinkedList<String> loader() throws ClassNotFoundException, IOException {
		return (LinkedList<String>) in.readObject();
	}
}
