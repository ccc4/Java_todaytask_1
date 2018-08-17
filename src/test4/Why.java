package test4;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;

import javax.swing.table.DefaultTableModel;

class A implements Serializable {
	DefaultTableModel model;

	public DefaultTableModel getModel() {
		return model;
	}

	public void setModel(DefaultTableModel model) {
		this.model = model;
	}
}

public class Why {
	String fileName = "why.txt";
	File file;
	public Why() throws IOException {
		file = new File(fileName);
		if(!file.exists()) {
			file.createNewFile();
		}
	}
	
	public void b(A a) throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		out.writeObject(a);
		System.out.println("b ¿Ï·á");
		out.close();
	}
	
	public static void main(String[] args) throws IOException {
		Why why = new Why();
		A a = new A();
		Object[][] columnNames = null;
		Object[] rowCount = {" "};
		a.setModel(new DefaultTableModel(columnNames, rowCount));
		
		why.b(a);
	}
}
