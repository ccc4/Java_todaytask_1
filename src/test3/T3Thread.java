package test3;

import java.io.IOException;

public class T3Thread extends Thread {
	Test333 t3;
	public T3Thread(Test333 t3) {
		this.t3 = t3;
	}
	
	@Override
	public void run() {
		try {
			t3.loader();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
