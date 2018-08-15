package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

public class Test222 implements Serializable {
	LinkedList<String> contents;
	private File file = new File("abcd.txt");
	ObjectOutputStream out;
	ObjectInputStream in;

	public Test222() throws IOException, ClassNotFoundException {

		if (!file.exists()) {
			file.createNewFile();
		}
		out = new ObjectOutputStream(new FileOutputStream(file));
		in = new ObjectInputStream(new FileInputStream(file));
//		contents = new LinkedList<>();
//		out.writeObject(contents);
		
		if (in.readObject().equals(null)) {
			this.contents = new LinkedList<>();
			out.writeObject(this.contents);
		} else {
			this.contents = (LinkedList<String>) in.readObject();
		}
		
//		LinkedList<String> a = (LinkedList<String>) in.readObject();
		System.out.println(this.contents.size());
	}
	
	public static void main(String[] args) throws ClassNotFoundException, IOException {
		new Test222();
	}
}
