package test3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Scanner;

public class Test333 {
	LinkedList<String> train;
	File file = new File("test333.txt");
	PrintWriter out;
	BufferedReader in;
	String value;
	
	public Test333() throws IOException {
		train = new LinkedList<>();
		if (!file.exists()) {
			file.createNewFile();
		}
	}
	
	public void output(String str) throws IOException {
		out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true))));
		
		out.println(str);
		
		
		out.close();
		loader();
	}
	
	public void loader() throws IOException {
		in = new BufferedReader((new FileReader(file)));
		if(in.readLine() == null) {
			System.out.println("비었음");
		} else {
			while((value=in.readLine()) != null) {
				train.add(value);
			}
			for(int i=0;i<train.size();i++) {
				System.out.println(train.get(i));
			}
			
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		Test333 t3 = new Test333();
		t3.loader();
		while(true) {
			System.out.print("입력: ");
			t3.output(sc.nextLine());
		}
	}
}
