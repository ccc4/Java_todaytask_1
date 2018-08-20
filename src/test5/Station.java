package test5;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import javax.swing.table.DefaultTableModel;

public class Station {
	private File file;
	private Item item;
	private DefaultTableModel model;
	private String[] inputStr = new String[1];
	private ObjectInputStream in;
	
	
	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public Station() throws IOException, ClassNotFoundException {
		file = new File("test5.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		if(check.readLine() == null) {
			item = new Item();
			output(item);
			model = item.getModel();
		} else {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			item = (Item) in.readObject();
			model = item.getModel();
			in.close();
		}
		check.close();
	}
	
	public void addContent(String getText) throws FileNotFoundException, IOException {
		inputStr[0] = getText;
		model.addRow(inputStr);
		item.setModel(model);
		output(item);
		System.out.println("addContent success!");
	}
	
	public void delContent(int getRow) throws FileNotFoundException, IOException {
//		System.out.println(model.getRowCount());
//		System.out.println(item.getModel().getRowCount());
		
		model.removeRow(getRow);
		
//		System.out.println(model.getRowCount());
		
		
//		System.out.println(item.getModel().getRowCount());
		item.setModel(model); 
//		System.out.println(item.getModel().getRowCount());
		output(item);
		System.out.println("delContent success!");
	}
	
	public void output(Item item) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		out.writeObject(item);
		out.flush();
		System.out.println("output success!");
		out.close();
	}
	
//	public void loader() throws FileNotFoundException, IOException, ClassNotFoundException {
//		in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
//		item = (Item) in.readObject();
//		for(int i = 0;i<item.getModel().getRowCount();i++) {
//			System.out.println(item.getModel().getValueAt(i, 0));
//			
//		}
//	}
	
}
