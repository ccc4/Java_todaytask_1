package test3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class T3_Class {
	LinkedList<String> contents;
	private File file = new File("data3.txt");
	ObjectOutputStream out;
	ObjectInputStream in;

	public T3_Class() throws IOException, ClassNotFoundException {

		if (!file.exists()) {
			file.createNewFile();
		}
		out = new ObjectOutputStream(new FileOutputStream(file));
		in = new ObjectInputStream(new FileInputStream(file));
		
		if (in.readObject() == null) {
			this.contents = new LinkedList<>();
			out.writeObject(this.contents);
		} else {
			this.contents = (LinkedList<String>) in.readObject();
		}
		
	}
//
//	public synchronized LinkedList<String> load() throws InterruptedException {
////		this.wait();
//		System.out.println("·Îµå");
////		LinkedList<String> train = this.contents;
//		return this.contents;
//	}
//	
	public static void main(String[] args) throws ClassNotFoundException, IOException, InterruptedException {
		T3_Class t3c = new T3_Class();
		
	}
}
