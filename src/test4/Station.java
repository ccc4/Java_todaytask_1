package test4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.Serializable;

import javax.swing.table.DefaultTableModel;


class Item implements Serializable {
	DefaultTableModel model;
	
	public void setModel(DefaultTableModel model) {
		this.model = model;
	}

	public DefaultTableModel getModel() {
		return model;
	}
	
	
}

public class Station {
	File file;
	DefaultTableModel model;
	ObjectInputStream in;
	Item item;
	
	public Station() throws IOException, ClassNotFoundException {
		item = new Item();
		file = new File("test4.txt");
		if(!file.exists()) {
			file.createNewFile();
		}
		
		BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		if(check.readLine() == null) {
			Object[][] columnNames = null;
			Object[] rowCount = {" "};
			this.model = new DefaultTableModel(columnNames, rowCount);
			item.setModel(this.model);
			output(item);
		} else {
			in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
			item = (Item) in.readObject();
			this.model = item.getModel();
			in.close();
		}
		check.close();
	}
	
	public void input(String getText) throws FileNotFoundException, IOException {
		String[] inputStr = new String[1];
		inputStr[0] = getText;
		this.model.addRow(inputStr);
		item.setModel(this.model);
		output(item);
	}
	
	public void output(Item item) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		out.writeObject(item);
		System.out.println("output ¿Ï·á");
		out.close();
	}
	
	public void loader() throws FileNotFoundException, IOException, ClassNotFoundException {
		in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		item = (Item) in.readObject();
		for(int i = 0;i<item.getModel().getRowCount();i++) {
			System.out.println(item.getModel().getValueAt(i, 0));
			
		}
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
//		Item item = new Item();
		
		Station station = new Station();
		station.loader();
		
		
	}
}
