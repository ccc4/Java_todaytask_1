package test6;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Station implements Serializable {
	private final String saveDirName = ".";
	private final String saveFileName = "Item.bat";
	
	File file;
	ArrayList<String> items;
	
	public Station() {
		try {
			file = new File(saveDirName, saveFileName);
			if (!file.exists()) {
				file.createNewFile();
				System.out.println("new file create");
			}
			
			BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			if(check.readLine() == null) {
				items = new ArrayList<>();
				System.out.println("new file contents create");
				saveArrayList(items);
			} else {
				ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
				items = (ArrayList<String>) in.readObject();
				in.close();
			}
			check.close();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void addItem(String item) {
		items.add(item);
		saveArrayList(items);
	}
	
	public void delItem(int index) {
		items.remove(index);
		saveArrayList(items);
	}
	
	public void saveArrayList(ArrayList<String> items) {
		try {
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			out.writeObject(items);
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
