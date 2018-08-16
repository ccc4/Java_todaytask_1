package test4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;

import javax.swing.table.DefaultTableModel;

import sun.jvm.hotspot.utilities.ObjectReader;

class Item implements Serializable {
	DefaultTableModel model;
	
	public Item(DefaultTableModel model) {
		this.model = model;
	}
}

public class PPAP {
	File file = new File("ppat.txt");
	
	
	public PPAP() throws IOException {
		BufferedReader check = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		
		if(check.readLine() == null) {
			Object[][] columnNames = null;
			Object[] rowCount = {" "};
			DefaultTableModel model = new DefaultTableModel(columnNames, rowCount);
		} else {
			ObjectReader in = new ObjectReader()
		}
	}
}
