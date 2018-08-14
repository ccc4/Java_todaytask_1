package test2;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

public class T2_Class {
	LinkedList<String> contents;
	private File file = new File("data.txt");
	
	
	public T2_Class() throws IOException, ClassNotFoundException {
		
		if(!file.exists()) {
			file.createNewFile();
		}
		
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		
		if(in.readObject() == null) {
			this.contents = new LinkedList<>();
		} else {
			this.contents = (LinkedList<String>) in.readObject();
		}
		
		in.close();
	}
	
	public synchronized LinkedList<String> load() throws InterruptedException {
		this.wait();
		return this.contents;
	}
	
	public synchronized void input(String getText) {
		this.contents.add(getText);
		this.notifyAll();
	}
	
	public synchronized void output() throws FileNotFoundException, IOException, InterruptedException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
		
		out.writeObject(contents);
		out.flush();
		System.out.println("저장완료");
		this.wait();
		out.close();
	}
}
