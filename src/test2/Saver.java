package test2;

import java.io.IOException;

public class Saver extends Thread{
	private T2_Class t2c;
	
	public Saver(T2_Class t2c) {
		this.t2c = t2c;
	}
	
	@Override
	public void run() {
		try {
			t2c.output();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
