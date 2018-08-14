package test1;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class SaveClass {
	private String dirName = "." + File.separator;
	private String fileName = "Test_1_Save.txt";
	private File dir = new File(dirName);
	private File file = new File(dir, fileName);
	
	LinkedList<String> aTrain;
	
	ObjectInputStream in;
	
	public SaveClass() throws IOException, ClassNotFoundException {
		
		// ���� ���� �� ����
		if(!dir.exists()) {
			dir.mkdirs();
			if(!file.exists()) {
				file.createNewFile();
			}
		}
		
		// ������Ʈ �ҷ�����. ���� �ÿ� ���� ����� ������ �ҷ��ͼ� ��������.
		in = new ObjectInputStream(
					new BufferedInputStream(
							new FileInputStream(file)));
		System.out.println(in.readObject());
		if(in.readObject() == null) {
			aTrain = new LinkedList<>();
		} else {
			aTrain = (LinkedList<String>) in.readObject();
		}
	}
	
	
	
	public LinkedList<String> loader() throws ClassNotFoundException, IOException {
		return (LinkedList<String>) in.readObject();
	}
	
	
	
	public void saver(String getText) throws FileNotFoundException, IOException {
		String[] inputStr = new String[1];
		// �Ű����� �޾Ƽ� train �� ����
		inputStr[0] = getText;
		aTrain.add(inputStr[0]);
		
		ObjectOutputStream out = 
				new ObjectOutputStream(
						new BufferedOutputStream(
								new FileOutputStream(file)));
		
		out.writeObject(aTrain);
		System.out.println("�ֱ�üũ");
//		out.close();
//		in.close();
	}
	
}
