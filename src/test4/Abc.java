package test4;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.table.DefaultTableModel;

public class Abc {
	
		DefaultTableModel model;
		File file = new File("test4.txt");
		
		
		public Abc() throws IOException{
			if(!file.exists()) {
				file.createNewFile();
			}
			
			BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
			if(in.readLine() == null) {
				Object[][] columnNames = null;
				Object[] rowCount = {" "};
				model = new DefaultTableModel(columnNames, rowCount);
				out.writeObject(model);
			}
			
			
			
		}
		public Abc(DefaultTableModel model) {
			this.model = model;
		}
		
		public static void main(String[] args) throws ClassNotFoundException, IOException {
			new Abc();
		}

		
	
}
