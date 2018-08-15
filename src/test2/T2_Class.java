package test2;

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

public class T2_Class {
	LinkedList<String> contents;
	private File file = new File("data.dat");
	ObjectOutputStream out;
	ObjectInputStream in;
	
	
	public T2_Class() throws IOException, ClassNotFoundException {

		if (!file.exists()) {
			file.createNewFile();
		}
		out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
		in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		if (in.readObject() == null) {
			this.contents = new LinkedList<>();
			out.writeObject(this.contents);
		} else {
			this.contents = (LinkedList<String>) in.readObject();
		}
		
		in.close();
		System.out.println("생성자");
	}

	public synchronized LinkedList<String> load() throws InterruptedException {
//		this.wait();
		System.out.println("로드");
//		LinkedList<String> train = this.contents;
		return this.contents;
	}

	public synchronized void input(String getText) {
		this.contents.add(getText);
//		this.notifyAll();
		System.out.println("인풋");
	}

	public synchronized void output() throws FileNotFoundException, IOException, InterruptedException {
		

		out.writeObject(contents);
		out.flush();
		System.out.println("저장완료");
//		this.wait();
		out.close();
	}
}
